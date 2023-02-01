package com.LaboratoryApp.labappv001.Exception;

public class LaboratoryTechnicianNotFoundException extends Exception{
    public LaboratoryTechnicianNotFoundException(Long technicianId) {
        super("Technician with id - " + technicianId + " not found.");
    }
}
