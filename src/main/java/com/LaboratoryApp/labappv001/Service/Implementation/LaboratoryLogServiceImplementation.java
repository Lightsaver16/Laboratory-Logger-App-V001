package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Repository.LaboratoryRepository;
import com.LaboratoryApp.labappv001.Service.LaboratoryLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryLogServiceImplementation implements LaboratoryLogService {

    private LaboratoryRepository laboratoryRepository;

    public LaboratoryLogServiceImplementation(LaboratoryRepository laboratoryRepository) {
        this.laboratoryRepository = laboratoryRepository;
    }

    @Override
    public LaboratoryLog create(LaboratoryLog laboratoryLog) {
        return laboratoryRepository.save(laboratoryLog);
    }

    @Override
    public List<LaboratoryLog> getAllLogs() {
        return laboratoryRepository.findAll();
    }

    @Override
    public LaboratoryLog findLaboratoryLogById(Long laboratoryId) {
        return laboratoryRepository.findById(laboratoryId)
                .orElseThrow(()-> new RuntimeException("Log not found."));
    }
}
