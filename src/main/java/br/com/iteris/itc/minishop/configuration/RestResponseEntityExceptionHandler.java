package br.com.iteris.itc.minishop.configuration;

import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public record JsonResponse(
            String timestamp,
            int status,
            String error,
            String message,
            String path)
    {}

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<JsonResponse> handleNotFound(RuntimeException ex, WebRequest request, final HttpServletRequest httpServletRequest){
        JsonResponse json = new JsonResponse(
                ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage(),
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }
}