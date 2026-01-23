package com.sentinel;

import java.util.Base64;

public class EncryptionDecorator extends ReportDecorator {

    public EncryptionDecorator(ReportProcessor nextProcessor) {
        super(nextProcessor);
    }

    private String encrypt(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    @Override
    public String process(String data) {
        // 1. Let the previous layers do their work first
        String dataFromPreviousLayers = super.process(data);

        // 2. Now add our "Decoration" (Encryption)
        System.out.println("-> Sentinel: Encrypting data...");
        return encrypt(dataFromPreviousLayers);

    }
}
