package com.LaboratoryApp.labappv001.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "technicians")
public class LaboratoryTechnician {

    @Id
    @SequenceGenerator(
            name = "technician_sequence",
            sequenceName = "technician_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technician_sequence")
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "contact_number")
    private String contactNumber;

    @OneToOne(mappedBy = "technician")
    private Laboratory laboratory;
}
