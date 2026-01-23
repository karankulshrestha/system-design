package com.sentinel;


public class Main {
    public static void main(String[] args) {
        String sensitiveReport = "This is a confidential report for user: 12345.";

        System.out.println("=== CASE 1: Basic Pipeline ===");
        ReportProcessor simplePipeline = new BasicReportProcessor();
        System.out.println("Result: " + simplePipeline.process(sensitiveReport));

        System.out.println("\n-----------------------------------\n");

        // CASE 2: Secure Pipeline (Encryption only)
        System.out.println("=== CASE 2: Encrypted Pipeline ===");
        // We wrap the Basic processor inside the Encryption decorator
        ReportProcessor encryptedPipeline = new EncryptionDecorator(new BasicReportProcessor());
        System.out.println("Result: " + encryptedPipeline.process(sensitiveReport));

        System.out.println("\n-----------------------------------\n");

        // CASE 3: The "Full Sentinel" (Masking AND Encryption)
        System.out.println("=== CASE 3: Full Sentinel Pipeline ===");

        // CASE 3: The "Full Sentinel" (Masking AND Encryption)
        System.out.println("=== CASE 3: Full Sentinel Pipeline ===");
        // Watch the chaining:
        // Encryption -> wraps -> PII Masking -> wraps -> Basic Processor
        ReportProcessor fullPipeline = new EncryptionDecorator(
                new PIIMaskingDecorator(
                        new BasicReportProcessor()
                )
        );

        System.out.println("Result: " + fullPipeline.process(sensitiveReport));


    }
}