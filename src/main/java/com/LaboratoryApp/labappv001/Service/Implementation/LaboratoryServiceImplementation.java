package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.DTO.LaboratoryDTO;
import com.LaboratoryApp.labappv001.Exception.LaboratoryNotFoundException;
import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.Laboratory;
import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;
import com.LaboratoryApp.labappv001.Repository.LaboratoryRepository;
import com.LaboratoryApp.labappv001.Repository.LaboratoryTechnicianRepository;
import com.LaboratoryApp.labappv001.Service.LaboratoryService;
import com.LaboratoryApp.labappv001.Utility.LaboratoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryServiceImplementation implements LaboratoryService {

    private LaboratoryRepository laboratoryRepository;

    private LaboratoryTechnicianRepository laboratoryTechnicianRepository;

    private LaboratoryMapper laboratoryMapper;

    @Autowired
    public LaboratoryServiceImplementation(LaboratoryRepository laboratoryRepository, LaboratoryTechnicianRepository laboratoryTechnicianRepository, LaboratoryMapper laboratoryMapper) {
        this.laboratoryRepository = laboratoryRepository;
        this.laboratoryTechnicianRepository = laboratoryTechnicianRepository;
        this.laboratoryMapper = laboratoryMapper;
    }

    @Override
    public Laboratory create(Laboratory laboratory) {
        return laboratoryRepository.save(laboratory);
    }

    @Override
    public LaboratoryDTO findLaboratoryById(Long laboratoryId) throws LaboratoryNotFoundException {
        Optional<Laboratory> laboratory = laboratoryRepository.findById(laboratoryId);

        if (laboratory.isEmpty()) {
            throw new LaboratoryNotFoundException(laboratoryId);
        }

        return laboratoryMapper.toLaboratoryDTO(laboratory.get());
    }

    @Override
    public List<Laboratory> findAllLaboratories() {
        return laboratoryRepository.findAll();
    }

    @Override
    public Laboratory assignTechnician(Long laboratoryId, Long technicianId) throws LaboratoryNotFoundException, LaboratoryTechnicianNotFoundException {
        Optional<Laboratory> laboratory = laboratoryRepository.findById(laboratoryId);
        Optional<LaboratoryTechnician> technician = laboratoryTechnicianRepository.findById(technicianId);

        if (laboratory.isEmpty()) {
            throw new LaboratoryNotFoundException(laboratoryId);
        }

        if (technician.isEmpty()) {
            throw new LaboratoryTechnicianNotFoundException(technicianId);
        }

        laboratory.get().setTechnician(technician.get());

        return laboratoryRepository.save(laboratory.get());
    }
}
