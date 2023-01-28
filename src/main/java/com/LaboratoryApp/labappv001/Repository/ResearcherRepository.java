package com.LaboratoryApp.labappv001.Repository;

import com.LaboratoryApp.labappv001.Model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, Long> {
}
