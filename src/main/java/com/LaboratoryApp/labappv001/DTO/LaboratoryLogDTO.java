package com.LaboratoryApp.labappv001.DTO;

import com.LaboratoryApp.labappv001.Model.Researcher;
import lombok.Data;

import java.util.Set;

@Data
public class LaboratoryLogDTO {
    private String date;
    private String time;
    private Set<Researcher> researchers;
    private Long laboratoryId;
}
