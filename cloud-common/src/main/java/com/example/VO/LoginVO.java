package com.example.VO;

import java.io.Serializable;

public class LoginVO implements Serializable {
    private Long userId;
    private String token;

    public LoginVO() {}

    public LoginVO(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
