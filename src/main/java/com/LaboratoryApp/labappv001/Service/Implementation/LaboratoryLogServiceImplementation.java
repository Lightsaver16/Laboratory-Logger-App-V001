package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Repository.LaboratoryLogRepository;
import com.LaboratoryApp.labappv001.Service.LaboratoryLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LaboratoryLogServiceImplementation implements LaboratoryLogService {

    private LaboratoryLogRepository laboratoryLogRepository;

    public LaboratoryLogServiceImplementation(LaboratoryLogRepository laboratoryLogRepository) {
        this.laboratoryLogRepository = laboratoryLogRepository;
    }

    @Override
    public LaboratoryLog create(LaboratoryLog laboratoryLog) {
        return laboratoryLogRepository.save(laboratoryLog);
    }

    @Override
    public List<LaboratoryLog> getAllLogs() {
        return laboratoryLogRepository.findAll();
    }

    @Override
    public LaboratoryLog findLaboratoryLogById(Long logId) throws LaboratoryLogNotFoundException {
        Optional<LaboratoryLog> log = laboratoryLogRepository.findById(logId);

        if (log.isEmpty()) {
            throw new LaboratoryLogNotFoundException(logId);
        }

        return log.get();
    }

    @Override
    public LaboratoryLog updateDateAndTime(Long logId, LaboratoryLog log) throws LaboratoryLogNotFoundException {
        Optional<LaboratoryLog> laboratoryLog = laboratoryLogRepository.findById(logId);

        if (laboratoryLog.isEmpty()) {
            throw new LaboratoryLogNotFoundException(logId);
        }

        // Checks if the payload has date
        // If there is date, the log date will be updated.
        if (Objects.nonNull(log.getDate()) &&
                !"".equalsIgnoreCase(log.getDate())) {
            laboratoryLog.get().setDate(log.getDate());
        }

        // Checks if the payload has date
        // If there is date, the log date will be updated.
        if (Objects.nonNull(log.getTime()) &&
                !"".equalsIgnoreCase(log.getTime())) {
            laboratoryLog.get().setTime(log.getTime());
        }

        return laboratoryLogRepository.save(laboratoryLog.get());
    }

    @Override
    public void delete(Long logId) throws LaboratoryLogNotFoundException {
        Optional<LaboratoryLog> log = laboratoryLogRepository.findById(logId);

        if (log.isEmpty()) {
            throw new LaboratoryLogNotFoundException(logId);
        }

        laboratoryLogRepository.deleteById(logId);
    }

}
