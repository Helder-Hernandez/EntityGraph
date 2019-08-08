package com.softwarehut.jpa.entityGraph.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.softwarehut.jpa.entityGraph.model.Company;

interface ICompanyCrudRepository extends CrudRepository<Company, Long>{
	
	//@EntityGraph(attributePaths = {"departments.employees.address", "departments.offices"})
	@EntityGraph(attributePaths = {"departments.employees", "departments.offices"})
	@Query("select c from Company c where c.id = :id")
	Company findByDeptoId(@Param("id") Long companyId);
}

@Service(value = "implCrudRespository")
public class CompanyServiceImplCrudRepository implements CompanyService{
	@Autowired
	private ICompanyCrudRepository companyRepository;

	@Override
	public Company getCompanyWithDepartments(Long companyId) {
		// TODO Auto-generated method stub
		return companyRepository.findByDeptoId(companyId);
	}

	@Override
	public Company getCompanyWithDepartmentsAndEmployees(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyWithDepartmentsAndEmployeesAndOffices(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company getCompanyWithCars(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
