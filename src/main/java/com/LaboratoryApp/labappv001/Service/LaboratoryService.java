package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.Exception.LaboratoryNotFoundException;
import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.Laboratory;

import java.util.List;

public interface LaboratoryService {
    Laboratory create(Laboratory laboratory);
    Laboratory findLaboratoryById(Long laboratoryId) throws LaboratoryNotFoundException;
    List<Laboratory> findAllLaboratories();

    Laboratory assignTechnician(Long laboratoryId, Long technicianId) throws LaboratoryNotFoundException, LaboratoryTechnicianNotFoundException;
}
