package com.LaboratoryApp.labappv001.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "researchers") // name of table in db
public class Researcher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long researcherId;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "contact_number")
    private String contactNumber; // String because some contact number may start with 0 (e.g. 0915, 0965)

//    @Column(name = "specialization")
//    private Specialization specialization;
    @ManyToMany
    @JoinTable(
            name = "researcher_log",
            joinColumns = @JoinColumn(name = "researcher_id"),
            inverseJoinColumns = @JoinColumn(name = "log_id")
    )
    @JsonIgnore
    private List<LaboratoryLog> laboratoryLogs;
}
