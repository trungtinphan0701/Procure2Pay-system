package hosi.procure2pay.exception.handler;

import hosi.procure2pay.exception.BadRequestError;
import hosi.procure2pay.exception.InternalServerError;
import hosi.procure2pay.exception.ResponseException;
import hosi.procure2pay.exception.UnAuthError;
import hosi.procure2pay.model.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.nio.file.AccessDeniedException;


@ControllerAdvice
public class CommonsExceptionHandler {
    public CommonsExceptionHandler() {
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Response> handleAccessDenied(AccessDeniedException e) {
        return ResponseEntity.ok(new Response(new ResponseException(UnAuthError.FORBIDDEN)));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Response> handle(Exception e) {
        if (e instanceof ResponseException) {
            return ResponseEntity.ok(new Response(e));
        } else if (!(e instanceof HttpMessageNotReadableException) && !(e instanceof MissingServletRequestParameterException) && !(e instanceof MissingRequestHeaderException)) {
            if (e instanceof HttpRequestMethodNotSupportedException) {
                return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
            } else {
                return e instanceof MethodArgumentTypeMismatchException ? ResponseEntity.ok(new Response(new ResponseException(BadRequestError.BAD_REQUEST_ERROR, e.getMessage()))) : ResponseEntity.ok(new Response(new ResponseException(InternalServerError.INTERNAL_SERVER_ERROR, e.getMessage())));
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}