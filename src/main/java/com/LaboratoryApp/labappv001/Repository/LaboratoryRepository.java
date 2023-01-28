package com.LaboratoryApp.labappv001.Repository;

import com.LaboratoryApp.labappv001.Model.LaboratoryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<LaboratoryLog, Long> {
}
