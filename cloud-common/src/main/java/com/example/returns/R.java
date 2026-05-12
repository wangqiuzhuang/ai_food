package com.example.returns;

import lombok.Data;

@Data
public class R<T> {
    private String sysCode;    // 状态码 (200:成功, 500:失败)
    private String sysMessage;  // 提示信息
    private T data;          // 数据主体

    // 成功静态方法
    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setSysCode("0000");
        r.setSysMessage("操作成功");
        r.setData(data);
        return r;
    }

    // 失败静态方法
    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.setSysCode("9998");
        r.setSysMessage(message);
        return r;
    }
}