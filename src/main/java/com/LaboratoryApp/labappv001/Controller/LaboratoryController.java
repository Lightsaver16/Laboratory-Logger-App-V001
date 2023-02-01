package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Exception.LaboratoryNotFoundException;
import com.LaboratoryApp.labappv001.Exception.LaboratoryTechnicianNotFoundException;
import com.LaboratoryApp.labappv001.Model.Laboratory;
import com.LaboratoryApp.labappv001.Service.LaboratoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/laboratories")
public class LaboratoryController {

    private LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @PostMapping
    public ResponseEntity<Laboratory> create(@Valid @RequestBody Laboratory laboratory) {
        Laboratory laboratoryRecord = laboratoryService.create(laboratory);

        return new ResponseEntity<>(laboratoryRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> findLaboratoryById(@PathVariable("id") Long laboratoryId) {

        try {
            Laboratory laboratory = laboratoryService.findLaboratoryById(laboratoryId);
            return new ResponseEntity<>(laboratory, HttpStatus.OK);
        } catch (LaboratoryNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Laboratory>> findAllLaboratories() {

        List<Laboratory> laboratories = laboratoryService.findAllLaboratories();

        return new ResponseEntity<>(laboratories, HttpStatus.OK);
    }

    @PutMapping("/{laboratoryId}/technician/{technicianId}")
    public ResponseEntity<Laboratory> assignTechnician(@PathVariable("laboratoryId") Long laboratoryId,
                                                       @PathVariable("technicianId") Long technicianId) {

        try {
            Laboratory laboratory = laboratoryService.assignTechnician(laboratoryId, technicianId);
            return new ResponseEntity<>(laboratory, HttpStatus.ACCEPTED);
        } catch (LaboratoryNotFoundException | LaboratoryTechnicianNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
