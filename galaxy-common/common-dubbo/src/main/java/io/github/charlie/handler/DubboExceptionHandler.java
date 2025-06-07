package io.github.charlie.handler;

import io.github.charlie.result.Result;
import io.github.charlie.result.ResultCode;
import org.apache.dubbo.remoting.RemotingException;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author charlie-zhang-code
 * @version v1.0
 * @date 2025/4/13
 * @description RPC异常处理器
 */
@RestControllerAdvice
public class DubboExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RpcException.class)
    public <T> Result<T> processException(RpcException e) {
        return Result.failure(ResultCode.RPC_ERROR, ResultCode.RPC_ERROR.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RemotingException.class)
    public <T> Result<T> processException(Exception e) {
        return Result.failure(ResultCode.RPC_ERROR, ResultCode.RPC_ERROR.getMessage());
    }
}
