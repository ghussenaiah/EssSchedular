

package com.biometic.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biometic.model.Biometric_AttendanceData;
import com.biometic.model.EmployeeAndBioMetricRefNo;
import com.biometic.model.Server_Details;



@Repository
public interface EmployeeAndBioMetricMappingDao extends JpaRepository<EmployeeAndBioMetricRefNo, Long> {
	
	
	@Query("SELECT e FROM EmployeeAndBioMetricRefNo e WHERE e.biorefno IS NULL")
	public List<EmployeeAndBioMetricRefNo> findAll();
}