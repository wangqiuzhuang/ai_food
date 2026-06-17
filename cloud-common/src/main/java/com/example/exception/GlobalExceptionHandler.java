package com.example.exception;

import com.example.returns.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e) {
        log.error("系统运行异常: ", e);
        return R.error("服务器开小差了，请稍后再试");
    }

    @ExceptionHandler(RuntimeException.class)
    public R<String> handleRuntimeException(RuntimeException e) {
        log.error("业务异常: {}", e.getMessage());
        return R.error(e.getMessage());
    }
}
