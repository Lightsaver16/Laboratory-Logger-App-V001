package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Service.LaboratoryLogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/logs")
public class LaboratoryLogController {

    private LaboratoryLogService laboratoryLogService;


    public LaboratoryLogController(LaboratoryLogService laboratoryLogService) {
        this.laboratoryLogService = laboratoryLogService;
    }

    @PostMapping
    public ResponseEntity<LaboratoryLog> create(@Valid @RequestBody LaboratoryLog log) {
        LaboratoryLog laboratoryLog = laboratoryLogService.create(log);

        return new ResponseEntity<>(laboratoryLog, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LaboratoryLog>> logs() {
        List<LaboratoryLog> logs = laboratoryLogService.getAllLogs();

        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryLog> findLogById(@PathVariable("id") Long logId) {

        try {
            LaboratoryLog log = laboratoryLogService.findLaboratoryLogById(logId);
            return new ResponseEntity<>(log, HttpStatus.OK);
        } catch (LaboratoryLogNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<LaboratoryLog> updateDateAndTime(@PathVariable("id") Long logId,
                                                           @RequestBody LaboratoryLog log) {

        try {
            LaboratoryLog laboratoryLog = laboratoryLogService.updateDateAndTime(logId, log);
            return new ResponseEntity<>(laboratoryLog, HttpStatus.ACCEPTED);
        } catch (LaboratoryLogNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") Long logId) {
        try {
            laboratoryLogService.delete(logId);
            return new ResponseEntity<>("Log has been deleted.", HttpStatus.OK);
        } catch (LaboratoryLogNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
