package com.example.returns;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;    // 状态码 (200:成功, 500:失败)
    private String message;  // 提示信息
    private T data;          // 数据主体

    // 成功静态方法
    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMessage("操作成功");
        r.setData(data);
        return r;
    }

    // 失败静态方法
    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }
}