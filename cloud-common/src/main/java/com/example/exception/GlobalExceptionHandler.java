package com.example.exception;

import com.example.returns.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice // 关键：拦截所有 RestController
public class GlobalExceptionHandler {

    // 拦截所有未知的系统异常
    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e) {
        log.error("系统运行异常: ", e);
        return R.error("服务器开小差了，请稍后再试");
    }

    // 拦截特定异常（比如业务自定义异常）
    @ExceptionHandler(RuntimeException.class)
    public R<String> handleRuntimeException(RuntimeException e) {
        log.error("业务异常: {}", e.getMessage());
        return R.error(e.getMessage());
    }
}