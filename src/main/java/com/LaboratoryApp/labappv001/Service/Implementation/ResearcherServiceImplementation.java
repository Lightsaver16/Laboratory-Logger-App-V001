package com.LaboratoryApp.labappv001.Service.Implementation;

import com.LaboratoryApp.labappv001.Exception.LaboratoryLogNotFoundException;
import com.LaboratoryApp.labappv001.Exception.ResearcherNotFoundException;
import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import com.LaboratoryApp.labappv001.Model.Researcher;
import com.LaboratoryApp.labappv001.Repository.LaboratoryLogRepository;
import com.LaboratoryApp.labappv001.Repository.ResearcherRepository;
import com.LaboratoryApp.labappv001.Service.ResearcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResearcherServiceImplementation implements ResearcherService {

    private final ResearcherRepository researcherRepository;

    private final LaboratoryLogRepository laboratoryLogRepository;

    @Autowired
    public ResearcherServiceImplementation(ResearcherRepository researcherRepository,
                                           LaboratoryLogRepository laboratoryLogRepository) {
        this.researcherRepository = researcherRepository;
        this.laboratoryLogRepository = laboratoryLogRepository;
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
    public Researcher findResearcherById(Long researcherId) throws ResearcherNotFoundException {
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);

        if (researcher.isEmpty()) {
            throw new ResearcherNotFoundException(researcherId);
        } else {
            return researcher.get();
        }
    }

    @Override
    public void addToLog(Long researcherId, Long logId) throws ResearcherNotFoundException, LaboratoryLogNotFoundException {
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);
        Optional<LaboratoryLog> log = laboratoryLogRepository.findById(logId);

        if (researcher.isEmpty()) {
            throw new ResearcherNotFoundException(researcherId);
        }

        if (log.isEmpty()) {
            throw new LaboratoryLogNotFoundException(logId);
        }

        researcher.get().getLaboratoryLogs().add(log.get());
        researcherRepository.save(researcher.get());
    }

    @Override
    public Researcher update(Long researcherId, Researcher researcher) throws ResearcherNotFoundException {
        Optional<Researcher> researcherPerson = researcherRepository.findById(researcherId);

        if (researcherPerson.isEmpty()) {
            throw new ResearcherNotFoundException(researcherId);
        }

        // Checks if the payload has first name
        // If there is first name, the first name field will be updated.
        if (Objects.nonNull(researcher.getFirstName()) &&
        !"".equalsIgnoreCase(researcher.getFirstName())) {
            researcherPerson.get().setFirstName(researcher.getFirstName());
        }

        // Checks if the payload has last name
        // If there is first name, the last name field will be updated.
        if (Objects.nonNull(researcher.getLastName()) &&
                !"".equalsIgnoreCase(researcher.getLastName())) {
            researcherPerson.get().setLastName(researcher.getLastName());
        }

        // Checks if the payload has contact number
        // If there is first name, the contact number field will be updated.
        if (Objects.nonNull(researcher.getContactNumber()) &&
                !"".equalsIgnoreCase(researcher.getContactNumber())) {
            researcherPerson.get().setContactNumber(researcher.getContactNumber());
        }

        return researcherRepository.save(researcherPerson.get());
    }

    @Override
    public void delete(Long researcherId) throws ResearcherNotFoundException {
        Optional<Researcher> researcher = researcherRepository.findById(researcherId);

        if (researcher.isEmpty()) {
            throw new ResearcherNotFoundException(researcherId);
        } else {
            researcherRepository.deleteById(researcherId);
        }
    }
}
