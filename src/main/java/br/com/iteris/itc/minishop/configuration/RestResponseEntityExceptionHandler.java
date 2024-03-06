package br.com.iteris.itc.minishop.configuration;

import br.com.iteris.itc.minishop.core.exceptions.NotFoundException;
import br.com.iteris.itc.minishop.core.exceptions.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    public record ErrorField(
            String field,
            String message
    ) { }
    public record JsonResponse(
            String timestamp,
            int status,
            String error,
            String message,
            String path
    ) { }
    public record JsonErrorResponse(
            String timestamp,
            int status,
            String error,
            String message,
            String path,
            List<ErrorField> errors
    ) { }

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

    @ExceptionHandler(value = ValidationException.class)
    protected ResponseEntity<JsonResponse> handleValidationException(RuntimeException ex, WebRequest request, final HttpServletRequest httpServletRequest){
        JsonResponse json = new JsonResponse(
                ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Unprocessable Entity",
                ex.getMessage(),
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(json);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        List<ErrorField> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorField(
                        fieldError.getField(),
                        fieldError.getDefaultMessage()
                ))
                .toList();

        JsonErrorResponse json = new JsonErrorResponse(
                ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Unprocessable Entity",
                "The given data was invalid.",
                ((ServletWebRequest)request).getRequest().getRequestURI(),
                errors
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(json);
    }
}