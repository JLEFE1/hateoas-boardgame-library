package be.homegrown.exception;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class ExceptionAndErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public HttpEntity<Resources<ErrorResource>> userNotFoundException(EntityNotFoundException exception) {
        return handleException(HttpStatus.NOT_FOUND, exception, exception.getMessage());
    }

    private HttpEntity<Resources<ErrorResource>> handleException(HttpStatus status, Throwable ex) {
        return handleException(status, ex, null);
    }

    private HttpEntity<Resources<ErrorResource>> handleException(HttpStatus status, Throwable ex, String message) {
        log.error("exception has occurred status: {} message: {} ", status, message, ex);
        return handleException(status, ex, message, null);
    }

    private HttpEntity<Resources<ErrorResource>> handleException(HttpStatus status, Throwable ex, String message, String code) {
        log.error("exception has occurred status: {} message: {} code: {} ", status, message, code, ex);
        Resources<ErrorResource> res = new Resources<>(Lists.<ErrorResource>newArrayList(new ErrorResource(status, ex, message, code)));
        return new ResponseEntity<>(res, status);
    }
}
