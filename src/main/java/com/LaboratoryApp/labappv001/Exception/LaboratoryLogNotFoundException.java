package com.LaboratoryApp.labappv001.Exception;

public class LaboratoryLogNotFoundException extends Exception{
    public LaboratoryLogNotFoundException(Long logId) {
        super("Laboratory log with id " + logId + " not found.");
    }
}
