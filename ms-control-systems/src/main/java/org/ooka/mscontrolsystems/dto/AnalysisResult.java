package org.ooka.mscontrolsystems.dto;

public record AnalysisResult(String service, boolean success) {

    @Override
    public String toString() {
        return String.format("{\"service\": \"%s\", \"success\": %b}", service, success);
    }
}
