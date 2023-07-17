package com.biometic.repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biometic.model.Events_Errors;
import com.biometic.model.Server_Details;



@Repository
public interface EventsErrorsDao extends JpaRepository<Events_Errors, Long> {
	
	

 }