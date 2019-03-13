package com.ecommerce.member.model;

public class ApiKeyException extends RuntimeException {
    public ApiKeyException() {
        super("Api-Key is missing");
    }
}
