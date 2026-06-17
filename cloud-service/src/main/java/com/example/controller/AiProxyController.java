package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.returns.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * AI 代理 — 前端通过本接口调 DeepSeek API，API Key 只在服务端，不暴露给客户端
 */
@RestController
@RequestMapping("/ai")
public class AiProxyController {

    @Value("${DEEPSEEK_API_KEY:}")
    private String deepseekApiKey;

    private static final String DEEPSEEK_URL = "https://api.deepseek.com/v1/chat/completions";

    /**
     * 多轮对话
     */
    @PostMapping("/chat")
    public R<Map<String, Object>> chat(@RequestBody Map<String, Object> body) {
        return doRequest(body);
    }

    /**
     * 单轮生成（简化接口，和 chat 其实一样）
     */
    @PostMapping("/generate")
    public R<Map<String, Object>> generate(@RequestBody Map<String, Object> body) {
        return doRequest(body);
    }

    @SuppressWarnings("unchecked")
    private R<Map<String, Object>> doRequest(Map<String, Object> body) {
        try {
            String apiKey = deepseekApiKey;
            if (apiKey == null || apiKey.isEmpty()) {
                apiKey = System.getenv("DEEPSEEK_API_KEY");
            }
            if (apiKey == null || apiKey.isEmpty()) {
                return R.error("DEEPSEEK_API_KEY 未配置");
            }

            // 组装请求体
            JSONObject reqBody = new JSONObject();
            reqBody.put("model", body.getOrDefault("model", "deepseek-chat"));

            // 处理 messages
            Object messagesObj = body.get("messages");
            if (messagesObj instanceof List) {
                reqBody.put("messages", messagesObj);
            } else {
                // 兼容 AiService.generate() 的传参方式：直接传 prompt + 可选的 systemPrompt
                String prompt = (String) body.getOrDefault("prompt", "");
                String systemPrompt = (String) body.get("systemPrompt");

                JSONArray messages = new JSONArray();
                if (systemPrompt != null && !systemPrompt.isEmpty()) {
                    JSONObject sys = new JSONObject();
                    sys.put("role", "system");
                    sys.put("content", systemPrompt);
                    messages.add(sys);
                }
                JSONObject user = new JSONObject();
                user.put("role", "user");
                user.put("content", prompt);
                messages.add(user);
                reqBody.put("messages", messages);
            }

            reqBody.put("temperature", body.getOrDefault("temperature", 0.8));
            reqBody.put("max_tokens", body.getOrDefault("max_tokens", 512));

            // 发起请求
            RestTemplate rest = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<String> entity = new HttpEntity<>(reqBody.toJSONString(), headers);
            ResponseEntity<String> resp = rest.postForEntity(DEEPSEEK_URL, entity, String.class);

            JSONObject respJson = JSON.parseObject(resp.getBody());

            // 提取 content
            JSONArray choices = respJson.getJSONArray("choices");
            String content = "";
            if (choices != null && !choices.isEmpty()) {
                JSONObject first = choices.getJSONObject(0);
                JSONObject message = first.getJSONObject("message");
                if (message != null) {
                    content = message.getString("content");
                }
            }

            Map<String, Object> result = new HashMap<>();
            result.put("content", content);
            result.put("model", respJson.getString("model"));
            result.put("usage", respJson.getJSONObject("usage"));

            return R.ok(result);
        } catch (Exception e) {
            return R.error("AI 代理错误: " + e.getMessage());
        }
    }
}
