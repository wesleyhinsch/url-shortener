package com.hinsch.wishlist.infrastructure.gateway.exceptions;

public class UrlNotFoundException extends Exception {
    public UrlNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
