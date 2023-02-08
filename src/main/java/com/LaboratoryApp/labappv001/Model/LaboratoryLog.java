package com.LaboratoryApp.labappv001.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laboratory_logs")
public class LaboratoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long logId;

    @NotBlank
    private String date;

    @NotBlank
    private String time;

    @ManyToMany(mappedBy = "laboratoryLogs")
    private Set<Researcher> researchers;

    @ManyToOne
    @JoinColumn(
            name = "laboratory_id",
            referencedColumnName = "laboratoryId"
    )
    @JsonIgnore
    private Laboratory laboratory;
}
