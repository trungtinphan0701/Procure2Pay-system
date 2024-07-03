package hosi.procure2pay.exception;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public enum BadRequestError implements ResponseError {
    UNKNOWN(0, "Unknown error"),
    BAD_REQUEST_ERROR(100, "Bad request error"),
    USER_ID_NULL(99, "User id is null"),
    USER_ID_NOT_FOUND(101, "User id not found"),
    FIRST_NAME_INVALID(104, "First name is invalid"),
    LAST_NAME_INVALID(109, "Last name is invalid"),
    USER_EMAIL_NULL(106, "User email is null"),
    USER_EMAIL_ALREADY_EXISTS(102, "User email already exists"),
    USER_EMAIL_NOT_FOUND(103, "User email not found"),
    USER_NOT_FOUND(105, "User not found"),
    SUPPLIER_ID_NULL(107, "Supplier id is null"),
    SUPPLIER_NOT_FOUND(108, "Supplier not found"),

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