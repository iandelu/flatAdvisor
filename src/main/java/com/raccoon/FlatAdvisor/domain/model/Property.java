package com.raccoon.FlatAdvisor.domain.model;

import com.raccoon.FlatAdvisor.domain.vo.Address;
import com.raccoon.FlatAdvisor.domain.vo.EnergyInfo;
import com.raccoon.FlatAdvisor.domain.vo.Price;
import com.raccoon.FlatAdvisor.domain.vo.PropertySource;

import java.util.Collections;
import java.util.List;

public record Property(
        String reference,
        String title,
        String description,
        Price price,
        Address address,
        PropertyDetails details,
        EnergyInfo energyInfo,
        List<String> imagesUrl,
        PropertySource source
) {
    public Property {

        if (reference == null || reference.isBlank())
            throw new IllegalArgumentException("Reference cannot be null or empty");

    }

    public static Property mock(){
        return new Property(
                "0101010101",
                "Mock Property",
                "Mock Description",
                null,
                null,
                null,
                null,
                Collections.emptyList(),
                null
        );
    }
}
