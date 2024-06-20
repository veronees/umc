package umc.assign.apiPayload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.assign.apiPayload.ApiResponse;
import umc.assign.apiPayload.code.status.ErrorStatus;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<Object> handleException(GeneralException e) {
        return ResponseEntity.ok().body(ApiResponse.onFailure(e.getErrorReason().getCode(), e.getErrorReason().getMessage(), null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.badRequest().body(ApiResponse.onFailure(HttpStatus.BAD_REQUEST.toString()
                , e.getMessage(), null));
    }
}