package hosi.procure2pay.exception;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public enum BadRequestError implements ResponseError {
    UNKNOWN(0, "Unknown error"),
    BAD_REQUEST_ERROR(100, "Bad request error"),
    USER_ID_INVALID(101, "User id is invalid"),
    USER_NOT_FOUND(102, "User not found"),
    ;


    private final int errorCode;
    private final String message;

    BadRequestError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getName() {
        return this.name();
    }

    public Integer getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public int getStatus() {
        return HttpServletResponse.SC_BAD_REQUEST;
    }
}