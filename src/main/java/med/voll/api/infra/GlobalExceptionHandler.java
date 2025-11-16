package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handle404Error() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDataValidation>> handle400Error(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorDataValidation::new).toList());
    }

    public record ErrorDataValidation(String field, String message) {

        public ErrorDataValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
