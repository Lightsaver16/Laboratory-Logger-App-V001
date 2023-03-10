package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Exception.LaboratoryNotFoundException;
import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.Laboratory;
import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;
import com.LaboratoryApp.labappv001.Repository.LaboratoryRepository;
import com.LaboratoryApp.labappv001.Repository.LaboratoryTechnicianRepository;
import com.LaboratoryApp.labappv001.Service.LaboratoryTechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryTechnicianImplementation implements LaboratoryTechnicianService {

    private LaboratoryTechnicianRepository laboratoryTechnicianRepository;

    private LaboratoryRepository laboratoryRepository;

    @Autowired
    public LaboratoryTechnicianImplementation(LaboratoryTechnicianRepository laboratoryTechnicianRepository, LaboratoryRepository laboratoryRepository) {
        this.laboratoryTechnicianRepository = laboratoryTechnicianRepository;
        this.laboratoryRepository = laboratoryRepository;
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

    @Override
    public LaboratoryTechnician assignTechnician(Long technicianId, Long laboratoryId) throws LaboratoryNotFoundException, LaboratoryTechnicianNotFoundException {

        Optional<LaboratoryTechnician> technician = laboratoryTechnicianRepository.findById(technicianId);
        Optional<Laboratory> laboratory = laboratoryRepository.findById(laboratoryId);


        if (technician.isEmpty()) {
            throw new LaboratoryTechnicianNotFoundException(technicianId);
        }

        if (laboratory.isEmpty()) {
            throw new LaboratoryNotFoundException(laboratoryId);
        }

        technician.get().setLaboratory(laboratory.get());
        return laboratoryTechnicianRepository.save(technician.get());
    }
}
