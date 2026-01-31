package com.raccoon.FlatAdvisor.domain.vo;

public record Price(Integer amount, String currency) {

    public Price {
        if (amount == null) throw new IllegalArgumentException("Amount cannot be null");
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if (currency == null || currency.isBlank())
            throw new IllegalArgumentException("Currency cannot be null or empty");

    }

    public String format() {
        String symbol = getCurrencySymbol();
        return amount + " " + symbol;
    }

    private String getCurrencySymbol() {
        return switch (currency) {
            case "EUR" -> "€";
            case "USD" -> "$";
            case "GBP" -> "£";
            default -> currency;
        };
    }

    public static Price euros(Integer amount) {
        return new Price(amount, "EUR");
    }

    @Override
    public String toString() {
        return format();
    }
}
