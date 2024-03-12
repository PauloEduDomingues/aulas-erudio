package br.com.edu.paramsexceptions.exceptions.handler;

import br.com.edu.paramsexceptions.exceptions.ResponseException;
import br.com.edu.paramsexceptions.exceptions.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice //toda vez q um controller jogar uma exeção vai cair aqui
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseException> handleAllExceptions(Exception ex, WebRequest request){
        ResponseException responseException = new ResponseException(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ResponseException> handleBadRequestExceptions(Exception ex, WebRequest request){
        ResponseException responseException = new ResponseException(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
