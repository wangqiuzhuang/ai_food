package com.example.returns;

public class R<T> {
    private String sysCode;
    private String sysMessage;
    private T data;

    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.sysCode = "0000";
        r.sysMessage = "操作成功";
        r.data = data;
        return r;
    }

    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.sysCode = "9998";
        r.sysMessage = message;
        return r;
    }

    public String getSysCode() { return sysCode; }
    public void setSysCode(String sysCode) { this.sysCode = sysCode; }
    public String getSysMessage() { return sysMessage; }
    public void setSysMessage(String sysMessage) { this.sysMessage = sysMessage; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
