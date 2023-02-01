package com.LaboratoryApp.labappv001.Repository;

import com.LaboratoryApp.labappv001.Model.LaboratoryTechnician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryTechnicianRepository extends JpaRepository<LaboratoryTechnician, Long> {
}
