package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;
import com.LaboratoryApp.labappv001.Service.LaboratoryTechnicianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/technicians")
public class LaboratoryTechnicianController {

    private LaboratoryTechnicianService laboratoryTechnicianService;

    public LaboratoryTechnicianController(LaboratoryTechnicianService laboratoryTechnicianService) {
        this.laboratoryTechnicianService = laboratoryTechnicianService;
    }
    @PostMapping
    public ResponseEntity<LaboratoryTechnician> create(@RequestBody LaboratoryTechnician technician) {
        LaboratoryTechnician technician1 = laboratoryTechnicianService.create(technician);

        return new ResponseEntity<>(technician1, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryTechnician> findTechnicianById(@PathVariable("id") Long technicianId) {
        try {
            LaboratoryTechnician technician = laboratoryTechnicianService.findTechnicianById(technicianId);
            return new ResponseEntity<>(technician, HttpStatus.OK);
        } catch (LaboratoryTechnicianNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    public ResponseEntity<List<LaboratoryTechnician>> findAllTechnicians() {
        List<LaboratoryTechnician> technicians = laboratoryTechnicianService.findALlTechnicians();
        return new ResponseEntity<>(technicians, HttpStatus.OK);
    }
}
