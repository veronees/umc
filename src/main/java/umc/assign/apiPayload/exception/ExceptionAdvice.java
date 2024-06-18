package umc.assign.apiPayload.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.assign.apiPayload.ApiResponse;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleException(GeneralException e) {
        return ResponseEntity.ok().body(ApiResponse.onFailure(e.getErrorReason().getCode(), e.getErrorReason().getMessage(), null));
    }

}