package org.ooka.msmountingsystems.dto;

public record AnalysationResult(String service, boolean success) {

    @Override
    public String toString() {
        return String.format("{\"service\": \"%s\", \"success\": %b}", service, success);
    }
}