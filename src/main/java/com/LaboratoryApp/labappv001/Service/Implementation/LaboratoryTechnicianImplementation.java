package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;
import com.LaboratoryApp.labappv001.Repository.LaboratoryTechnicianRepository;
import com.LaboratoryApp.labappv001.Service.LaboratoryTechnicianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryTechnicianImplementation implements LaboratoryTechnicianService {

    private LaboratoryTechnicianRepository laboratoryTechnicianRepository;

    public LaboratoryTechnicianImplementation(LaboratoryTechnicianRepository laboratoryTechnicianRepository) {
        this.laboratoryTechnicianRepository = laboratoryTechnicianRepository;
    }

    @Override
    public LaboratoryTechnician create(LaboratoryTechnician technician) {
        return laboratoryTechnicianRepository.save(technician);
    }

    @Override
    public LaboratoryTechnician findTechnicianById(Long technicianId) throws LaboratoryTechnicianNotFoundException {
        Optional<LaboratoryTechnician> technician = laboratoryTechnicianRepository.findById(technicianId);

        if (technician.isEmpty()) {
            throw new LaboratoryTechnicianNotFoundException(technicianId);
        }

        return technician.get();
    }

    @Override
    public List<LaboratoryTechnician> findALlTechnicians() {
        return laboratoryTechnicianRepository.findAll();
    }
}
