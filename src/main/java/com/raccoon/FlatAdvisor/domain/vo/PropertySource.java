package com.raccoon.FlatAdvisor.domain.vo;

import com.raccoon.FlatAdvisor.domain.model.PropertyPortal;

import java.time.LocalDateTime;
import java.util.Objects;


public record PropertySource(
        PropertyPortal portal,
        String originalUrl,
        LocalDateTime scrapedAt
) {

    public PropertySource {
        if (portal == null) {
            throw new IllegalArgumentException("Portal cannot be null");
        }
        if (originalUrl == null || originalUrl.isBlank()) {
            throw new IllegalArgumentException("Original URL cannot be null or empty");
        }
        if (scrapedAt == null) {
            throw new IllegalArgumentException("Scraped timestamp cannot be null");
        }

    }

    public static PropertySource create(String url) {
        PropertyPortal detectedPortal = PropertyPortal.fromUrl(url);
        return new PropertySource(detectedPortal, url, LocalDateTime.now());
    }

    public boolean isFresh(int maxHoursOld) {
        LocalDateTime threshold = LocalDateTime.now().minusHours(maxHoursOld);
        return scrapedAt.isAfter(threshold);
    }

    public boolean isFrom(PropertyPortal targetPortal) {
        return this.portal == targetPortal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertySource that = (PropertySource) o;
        return portal == that.portal &&
                Objects.equals(originalUrl, that.originalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(portal, originalUrl);
    }

}