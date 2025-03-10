package munna.test.ExceptionHandlerExample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
         Error error = Error.builder()
                .message("Globally error found:  " + ex.getMessage())
                .exceptionName(ex.getClass().getSimpleName())
                .code(HttpStatus.NOT_FOUND.value())
                .build();
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
