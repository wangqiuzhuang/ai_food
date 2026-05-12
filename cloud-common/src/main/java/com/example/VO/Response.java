package com.example.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private String code;    // 状态码 (如: 200 成功, 500 失败)
    private String msg;  // 提示信息

}