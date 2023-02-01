package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;

import java.util.List;

public interface LaboratoryTechnicianService {

    LaboratoryTechnician create(LaboratoryTechnician technician);

    LaboratoryTechnician findTechnicianById(Long technicianId) throws LaboratoryTechnicianNotFoundException;

    List<LaboratoryTechnician> findALlTechnicians();
}
