package com.sentinel;

public abstract class ReportDecorator implements ReportProcessor {
    private ReportProcessor nextProcessor;

    public ReportDecorator(ReportProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public String process(String data) {
        return nextProcessor.process(data);
    }
}
