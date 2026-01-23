package com.sentinel;

public class BasicReportProcessor implements ReportProcessor {
    @Override
    public String process(String data) {
        // In a real system, this might save to a database.
        // For now, it just returns the raw data.
        System.out.println("-> Core: Reading raw report...");
        return data;
    }
}
