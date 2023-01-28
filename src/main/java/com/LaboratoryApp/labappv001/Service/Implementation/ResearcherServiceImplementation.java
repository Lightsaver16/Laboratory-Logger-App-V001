package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Model.Researcher;
import com.LaboratoryApp.labappv001.Repository.LaboratoryRepository;
import com.LaboratoryApp.labappv001.Repository.ResearcherRepository;
import com.LaboratoryApp.labappv001.Service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearcherServiceImplementation implements ResearcherService {

    private final ResearcherRepository researcherRepository;

    private final LaboratoryRepository laboratoryRepository;

    @Autowired
    public ResearcherServiceImplementation(ResearcherRepository researcherRepository,
                                           LaboratoryRepository laboratoryRepository) {
        this.researcherRepository = researcherRepository;
        this.laboratoryRepository = laboratoryRepository;
    }

    @Override
    public Researcher create(Researcher researcher) {
        return researcherRepository.save(researcher);
    }

    @Override
    public List<Researcher> getAllResearchers() {
        return researcherRepository.findAll();
    }

    @Override
    public Researcher findResearcherById(Long researcherId) {
        return researcherRepository.findById(researcherId)
                .orElseThrow(() -> new RuntimeException("Researcher not found."));
    }

    @Override
    public void addToLog(Long researcherId, Long logId) {
        Researcher researcher = researcherRepository.findById(researcherId)
                .orElseThrow(() -> new RuntimeException("Researcher not found."));
        LaboratoryLog log = laboratoryRepository.findById(logId)
                        .orElseThrow(()-> new RuntimeException("Log not found."));


        researcher.getLaboratoryLogs().add(log);
        researcherRepository.save(researcher);
    }
}
