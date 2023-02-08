package com.LaboratoryApp.labappv001.Utility;

import com.LaboratoryApp.labappv001.DTO.LaboratoryDTO;
import com.LaboratoryApp.labappv001.Model.Laboratory;
import org.springframework.stereotype.Component;

@Component
public class LaboratoryMapper {

    public LaboratoryDTO toLaboratoryDTO(Laboratory laboratory) {
        LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
        laboratoryDTO.setLaboratoryId(laboratory.getLaboratoryId());
        laboratoryDTO.setLaboratoryName(laboratory.getLaboratoryName());
        laboratoryDTO.setTechnicianFirstName(laboratory.getTechnician().getFirstName());
        laboratoryDTO.setTechnicianLastName(laboratory.getTechnician().getLastName());
        laboratoryDTO.setLogs(laboratory.getLogs());

        return laboratoryDTO;
    }
}
