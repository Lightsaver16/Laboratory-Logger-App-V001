package com.LaboratoryApp.labappv001.Service;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Exception.ResearcherNotFoundException;
import com.LaboratoryApp.labappv001.Model.Researcher;

import java.util.List;

public interface ResearcherService {
    Researcher create(Researcher researcher);

    List<Researcher> getAllResearchers();

    Researcher findResearcherById(Long researcherId) throws ResearcherNotFoundException;

    void addToLog(Long researcherId, Long logId) throws ResearcherNotFoundException, LaboratoryLogNotFoundException;

    Researcher update(Long researcherId, Researcher researcher) throws ResearcherNotFoundException;

    void delete(Long researcherId) throws ResearcherNotFoundException;

}
