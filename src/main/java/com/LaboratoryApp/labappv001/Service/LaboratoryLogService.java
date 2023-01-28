package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;

import java.util.List;

public interface LaboratoryLogService {
    LaboratoryLog create(LaboratoryLog laboratoryLog);

    List<LaboratoryLog> getAllLogs();

    LaboratoryLog findLaboratoryLogById(Long laboratoryId);
}
