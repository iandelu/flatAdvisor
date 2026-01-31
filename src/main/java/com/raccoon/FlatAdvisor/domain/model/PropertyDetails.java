package com.raccoon.FlatAdvisor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
public record PropertyDetails(
        String propertyType,
        String operationType,
        Integer rooms,
        Integer bathrooms,
        Integer toilets,
        Double usefulSurface,
        Double constructedSurface,
        String floor,
        String orientation,
        String terraceSurface
) {
}
