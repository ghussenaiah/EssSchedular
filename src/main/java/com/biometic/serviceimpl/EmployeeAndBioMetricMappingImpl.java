package com.biometic.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.biometic.model.EmployeeAndBioMetricRefNo;
import com.biometic.repository.EmployeeAndBioMetricMappingDao;

@Component
public class EmployeeAndBioMetricMappingImpl implements EmployeeAndBioMetricMappingDao {
	
	@Autowired
	EmployeeAndBioMetricMappingDao employeeAndBioMetricMappingDao;

	@Override
	public List<EmployeeAndBioMetricRefNo> findAll() {
		// TODO Auto-generated method stub
		return employeeAndBioMetricMappingDao.findAll();
	}

	@Override
	public List<EmployeeAndBioMetricRefNo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeAndBioMetricRefNo> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<EmployeeAndBioMetricRefNo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeAndBioMetricRefNo getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EmployeeAndBioMetricRefNo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> S save(S entity) {
		
		return employeeAndBioMetricMappingDao.save(entity);
	}

	@Override
	public Optional<EmployeeAndBioMetricRefNo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeAndBioMetricRefNo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends EmployeeAndBioMetricRefNo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends EmployeeAndBioMetricRefNo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
