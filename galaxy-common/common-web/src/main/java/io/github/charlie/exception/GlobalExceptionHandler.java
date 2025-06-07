package io.github.charlie.exception;

import cn.dev33.satoken.exception.NotLoginException;
import io.github.charlie.result.Result;
import io.github.charlie.result.ResultCode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public <T> Result<T> handleBizException(BusinessException e) {
        if (e.getResultCode() != null) {
            return Result.failure(e.getResultCode());
        }
        log.error("业务异常：{}", e.getMessage());
        return Result.failure(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public <T> Result<T> processException(ConstraintViolationException e) {
        String msg = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("；"));
        log.error("参数异常：{}", msg);
        return Result.failure(ResultCode.PARAM_ERROR, msg);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public <T> Result<T> processException(NoHandlerFoundException e) {
        log.error("请求地址不存在：{}", e.getMessage());
        return Result.failure(ResultCode.NOT_FOUND, e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public <T> Result<T> processException(NotLoginException e) {
        log.error("未登录：{}", e.getMessage());
        return Result.failure(ResultCode.LOGIN_EXPIRED, ResultCode.LOGIN_EXPIRED.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public <T> Result<T> processException(RuntimeException e) {
        log.error("系统异常：{}", e.getMessage());
        return Result.failure(ResultCode.SYSTEM_ERROR, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> Result<T> processException(MethodArgumentNotValidException e) {
        log.error("参数异常：{}", Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return Result.failure(ResultCode.PARAM_NOT_NULL);
    }
}
