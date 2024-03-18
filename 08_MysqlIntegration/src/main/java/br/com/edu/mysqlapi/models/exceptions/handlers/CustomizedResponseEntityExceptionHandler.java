package br.com.edu.mysqlapi.models.exceptions.handlers;

import br.com.edu.mysqlapi.models.exceptions.ResourceNotFound;
import br.com.edu.mysqlapi.models.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> handAllException(Exception ex, WebRequest request){
        ResponseException responseException = new ResponseException(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<ResponseException> handleNotFoundException(Exception ex, WebRequest request){
        ResponseException responseException = new ResponseException(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }
}
