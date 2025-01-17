package hosi.procure2pay.exception;

import jakarta.servlet.http.HttpServletResponse;

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
    REQUISITION_ID_NULL(109, "Requisition id is null"),
    SUPPLIER_ITEM_ID_NULL(110, "Supplier item id is null"),
    REQUISITION_NOT_FOUND(112, "Requisition not found"),
    SUPPLIER_ITEM_NOT_FOUND(113, "Supplier item not found"),
    ITEM_NOT_FOUND_IN_THIS_REQUISITION_SUPPLIER(114, "Item not found in this requisition supplier"),
    REQUISITION_ITEM_ID_IS_NULL(115, "Requisition item id is null"),
    INVALID_CREDENTIALS(116, "Invalid credentials"),
    PASSWORD_MISMATCH(117, "Password mismatch"),
    MIN_MUST_BE_SMALLER_THAN_MAX(116, "Minimum required amount is smaller than maximum allowed"),
    START_DATE_MUST_BE_BEFORE_END_DATE(117, "Start date must be before end date"),
    NAME_MUST_NOT_CONTAIN_ANY_NUMBER_OR_SPECIAL_CHARACTER(118, "Name must not contain any number or special character"),
    NAME_MUST_NOT_BE_EMPTY(119, "Name must not be empty"),
    USER_EMAIL_INVALID(120, "User email is invalid"),
    MUST_NOT_BE_NULL_OR_EMPTY(121, "Must not be null or empty"),
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