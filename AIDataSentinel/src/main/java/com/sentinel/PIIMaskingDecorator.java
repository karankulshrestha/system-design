package com.sentinel;

public class PIIMaskingDecorator extends ReportDecorator {

    public PIIMaskingDecorator(ReportProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public String process(String data) {
        // 1. Let the previous layers do their work
        String dataFromPreviousLayers = super.process(data);

        // 2. Add our "Decoration" (Masking sensitive info)
        System.out.println("-> Sentinel: Masking PII...");
        return dataFromPreviousLayers.replace("confidential", "***");
    }
}
