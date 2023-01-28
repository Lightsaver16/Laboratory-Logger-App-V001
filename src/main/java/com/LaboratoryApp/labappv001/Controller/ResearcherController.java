package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Model.Researcher;
import com.LaboratoryApp.labappv001.Service.ResearcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/researchers")
public class ResearcherController {

    private ResearcherService researcherService;

    public ResearcherController(ResearcherService researcherService) {
        this.researcherService = researcherService;
    }
    @PostMapping
    public ResponseEntity<Researcher> create(@RequestBody Researcher researcher) {
        Researcher researcher1 = researcherService.create(researcher);
        return ResponseEntity.ok(researcher1);
    }
    @GetMapping
    public ResponseEntity<List<Researcher>> getAllResearchers() {
        List<Researcher> researchers = researcherService.getAllResearchers();
        return ResponseEntity.ok(researchers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Researcher> getResearcherById(@PathVariable("id") Long researcherId) {
        Researcher researcher = researcherService.findResearcherById(researcherId);
        return ResponseEntity.ok(researcher);
    }
    @PutMapping("/{researcher_id}/logs/{log_id}")
    public ResponseEntity<String> addToLogs(@PathVariable("researcher_id") Long researcherId,
                                            @PathVariable("log_id")Long logId) {
        researcherService.addToLog(researcherId, logId);
        return ResponseEntity.ok("Researcher added to a log.");
    }
}
