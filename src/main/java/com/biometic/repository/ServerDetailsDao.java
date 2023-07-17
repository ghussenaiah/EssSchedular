package com.biometic.repository;






import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.biometic.model.Server_Details;



@Repository
public interface ServerDetailsDao extends JpaRepository<Server_Details, Long> {
	
	
	@Query("SELECT s FROM Server_Details s WHERE s.status = 'Active'")
	public List<Server_Details> findAll();
   
	
	
}