package hosi.procure2pay.exception;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

public enum BadRequestError implements ResponseError {
    UNKNOWN(0, "Unknown error"),
    BAD_REQUEST_ERROR(100, "Bad request error"),
    USER_ID_INVALID(101, "User id is invalid"),
    USER_NOT_FOUND(102, "User not found"),
    SUPPLIER_NAME_INVALID (103, "Supplier name is invalid"),
    SUPPLIER_ADDRESS_INVALID (104, "Supplier address is invalid"),
    SUPPLIER_PHONE_NUMBER_INVALID (105, "Supplier phone number is invalid"),
    SUPPLIER_ID_INVALID (106, "Supplier id is invalid"),
    SUPPLIER_ITEM_NAME_INVALID (107, "Item name is invalid"),
    PRICE_INVALID (108, "Price is invalid"),
    SUPPLIER_NOT_FOUND (109, "Supplier not found"),
    REQUISITION_ID_INVALID (110, "Requisition id is invalid"),
    SUPPLIER_ITEM_ID_INVALID (111, "Supplier item id is invalid"),
    QUANTITY_INVALID (112, "Quantity is invalid"),
    REQUISITION_NOT_FOUND (113, "Requisition not found"),
    SUPPLIER_ITEM_NOT_FOUND (114, "Supplier item not found"),

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