package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Service.LaboratoryLogService;
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
    public ResponseEntity<LaboratoryLog> create(@RequestBody LaboratoryLog log) {
        LaboratoryLog laboratoryLog = laboratoryLogService.create(log);
        return ResponseEntity.ok(laboratoryLog);
    }

    @GetMapping
    public ResponseEntity<List<LaboratoryLog>> logs() {
        List<LaboratoryLog> logs = laboratoryLogService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryLog> findLogById(@PathVariable("id") Long logId) {
        LaboratoryLog log = laboratoryLogService.findLaboratoryLogById(logId);
        return ResponseEntity.ok(log);
    }
}
