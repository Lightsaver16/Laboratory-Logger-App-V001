package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.Model.Researcher;

import java.util.List;

public interface ResearcherService {
    Researcher create(Researcher researcher);

    List<Researcher> getAllResearchers();

    Researcher findResearcherById(Long researcherId);

    void addToLog(Long researcherId, Long logId);

}
