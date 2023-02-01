package com.LaboratoryApp.labappv001.Exception;

public class LaboratoryNotFoundException extends Exception{
    public LaboratoryNotFoundException(Long laboratoryId) {
        super("Laboratory with id " + laboratoryId + " not found.");
    }
}
