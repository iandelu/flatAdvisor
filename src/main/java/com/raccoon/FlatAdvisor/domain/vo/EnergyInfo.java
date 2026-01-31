package com.raccoon.FlatAdvisor.domain.vo;

public record EnergyInfo(
        String certification,
        String status,
        Double emissions
) {

    public boolean hasCertification() {
        return certification != null &&
                !certification.isBlank() &&
                !certification.equalsIgnoreCase("En trámites");
    }

}
