package hosi.procure2pay.exception;

public interface ResponseError {
    String getName();
    String getMessage();
    int getStatus();
    default Integer getCode() {return 0;}
}