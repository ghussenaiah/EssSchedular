package com.biometic.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.biometic.model.Biometric_AttendanceData;


@Repository
public interface BiometricDao extends JpaRepository<Biometric_AttendanceData, Long> {
	
	
}
