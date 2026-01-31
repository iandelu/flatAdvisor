package com.raccoon.FlatAdvisor.domain.exceptions;

import java.io.IOException;

public class ScrapingException extends RuntimeException {

    private final String url;

    public ScrapingException( String url, String message) {
        super(message);
        this.url = url;
    }

    public ScrapingException(String message, String url, Throwable cause) {
        super(message, cause);
        this.url = url;
    }

    public String getUrl() {return url;}

    @Override
    public String getMessage() {
        return String.format("%s (URL: %s)", super.getMessage(), url);
    }
}
