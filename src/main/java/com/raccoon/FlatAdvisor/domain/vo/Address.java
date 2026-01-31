package com.raccoon.FlatAdvisor.domain.vo;

public record Address(
        String zone,
        String postalCode,
        String city,
        String fullAddress
) {

    public String getFormattedAddress() {
        StringBuilder sb = new StringBuilder();

        if (zone != null && !zone.isBlank()) {
            sb.append(zone);
        }
        if (postalCode != null && !postalCode.isBlank()) {
            if (!sb.isEmpty()) sb.append(", ");
            sb.append(postalCode);
        }
        if (city != null && !city.isBlank()) {
            if (!sb.isEmpty()) sb.append(", ");
            sb.append(city);
        }

        return sb.isEmpty() ? fullAddress : sb.toString();
    }

}
