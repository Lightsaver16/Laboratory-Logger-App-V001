package com.LaboratoryApp.labappv001.Controller;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Exception.ResearcherNotFoundException;
import com.LaboratoryApp.labappv001.Model.Researcher;
import com.LaboratoryApp.labappv001.Service.ResearcherService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Researcher> create(@Valid @RequestBody Researcher researcher) {
        Researcher researcherPerson = researcherService.create(researcher);

        return new ResponseEntity<>(researcherPerson, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Researcher>> getAllResearchers() {
        List<Researcher> researchers = researcherService.getAllResearchers();

        return new ResponseEntity<>(researchers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Researcher> getResearcherById(@PathVariable("id") Long researcherId) {
        try {
            Researcher researcher = researcherService.findResearcherById(researcherId);
            return new ResponseEntity<>(researcher, HttpStatus.OK);
        } catch (ResearcherNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{researcher_id}/logs/{log_id}")
    public ResponseEntity<String> addToLogs(@PathVariable("researcher_id") Long researcherId,
                                            @PathVariable("log_id")Long logId) {
        try {
            researcherService.addToLog(researcherId, logId);
            return new ResponseEntity<>("Researcher added to log.", HttpStatus.OK);
        } catch (ResearcherNotFoundException | LaboratoryLogNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Researcher> update(@PathVariable("id") Long researcherId,
                                             @RequestBody Researcher researcher) {

        try {
            Researcher researcherPerson = researcherService.update(researcherId, researcher);
            return new ResponseEntity<>(researcherPerson, HttpStatus.ACCEPTED);
        } catch (ResearcherNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") Long researcherId) {
        try {
            researcherService.delete(researcherId);
        } catch (ResearcherNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>("Researcher record has been deleted.", HttpStatus.OK);

    }
}
