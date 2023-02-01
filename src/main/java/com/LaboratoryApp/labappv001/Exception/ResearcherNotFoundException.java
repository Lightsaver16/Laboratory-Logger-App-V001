package com.LaboratoryApp.labappv001.Exception;

public class ResearcherNotFoundException extends Exception{
    public ResearcherNotFoundException(Long researcherId) {
        super("Researcher with id " + researcherId + " not found.");
    }
}
