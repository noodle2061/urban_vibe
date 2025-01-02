package com.main.urban_vibe.constants;

public class AppConstants {

    // API Response Messages
    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failure";
    public static final String ERROR = "Error";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String CART_NOT_FOUND = "Cart not found";
    public static final String ORDER_NOT_FOUND = "Order not found";
    public static final String INVALID_INPUT = "Invalid input";
    public static final String DUPLICATE_ENTRY = "Duplicate entry";
    public static final String ACCESS_DENIED = "Access denied";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";

    // Roles
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    // JWT
    public static final String JWT_TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER_STRING = "Authorization";
    // public static final String JWT_SECRET = "YourSecretKey"; // Moved to application.properties
    // public static final long JWT_EXPIRATION_TIME = 86400000; // 1 day (Moved to application.properties)

    // Date and Time Formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Pagination
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";

    // Order Statuses
    public static final String ORDER_STATUS_PENDING = "PENDING";
    public static final String ORDER_STATUS_PROCESSING = "PROCESSING";
    public static final String ORDER_STATUS_SHIPPED = "SHIPPED";
    public static final String ORDER_STATUS_DELIVERED = "DELIVERED";
    public static final String ORDER_STATUS_CANCELLED = "CANCELLED";

    // Payment Statuses
    public static final String PAYMENT_STATUS_PENDING = "PENDING";
    public static final String PAYMENT_STATUS_PAID = "PAID";
    public static final String PAYMENT_STATUS_FAILED = "FAILED";

    // Other constants
    public static final int MAX_LOGIN_ATTEMPTS = 5;
    public static final String DEFAULT_CURRENCY = "USD";

    // Private constructor to prevent instantiation
    private AppConstants() {
        throw new IllegalStateException("Constants class");
    }
}