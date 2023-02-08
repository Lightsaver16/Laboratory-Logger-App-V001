package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.DTO.LaboratoryLogDTO;
import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Exception.LaboratoryNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryLog;

import java.util.List;

public interface LaboratoryLogService {
    LaboratoryLogDTO create(LaboratoryLogDTO laboratoryLogDTO) throws LaboratoryNotFoundException;

    List<LaboratoryLog> getAllLogs();

    LaboratoryLog findLaboratoryLogById(Long laboratoryId) throws LaboratoryLogNotFoundException;

    LaboratoryLog updateDateAndTime(Long logId, LaboratoryLog log) throws LaboratoryLogNotFoundException;

    void delete(Long logId) throws LaboratoryLogNotFoundException;
}
