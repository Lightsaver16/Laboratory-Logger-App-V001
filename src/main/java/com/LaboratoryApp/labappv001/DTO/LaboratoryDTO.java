package com.LaboratoryApp.labappv001.DTO;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import lombok.Data;

import java.util.List;

@Data
public class LaboratoryDTO {
    private Long laboratoryId;
    private String laboratoryName;
    private List<LaboratoryLog> logs;
    private String technicianFirstName;
    private String technicianLastName;
}
