package com.makeitconsulting.scrumconnectapipoc.exception;

import com.makeitconsulting.scrumconnectapipoc.dto.ErrorField;
import com.makeitconsulting.scrumconnectapipoc.dto.ValidationErrorDto;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {
            @Override
            public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
                errorAttributes.remove("exception");
                return errorAttributes;
            }
        };
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleBadRequestError(MethodArgumentNotValidException ex) throws IOException {
        BindingResult bindingResult = ex.getBindingResult();
        List<ErrorField> fields = bindingResult.getFieldErrors().stream()
                .map(error -> ErrorField.builder().fieldName(error.getField()).message(error.getDefaultMessage()).build())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(ValidationErrorDto.builder().fields(fields).error(ex.getMessage()).build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletResponse res) throws IOException {
        return ResponseEntity.status(500).body("Something went wrong");
    }
}
