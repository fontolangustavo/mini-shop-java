package br.com.iteris.itc.minishop.configuration;

import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public record JsonResponse(int statusCode, String message) {}

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<JsonResponse> handleNotFound(RuntimeException ex, WebRequest request){
        JsonResponse json = new JsonResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }
}