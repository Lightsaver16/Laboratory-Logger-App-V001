package com.LaboratoryApp.labappv001.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laboratories")
public class Laboratory {

    @Id
    @SequenceGenerator(
            name = "laboratory_sequence",
            sequenceName = "laboratory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratory_sequence")
    private Long laboratoryId;

    @NotBlank
    @Column(name = "laboratory_name")
    private String laboratoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratory")
    private List<LaboratoryLog> logs;

    @OneToOne(mappedBy = "laboratory")
    private LaboratoryTechnician technician;
}
