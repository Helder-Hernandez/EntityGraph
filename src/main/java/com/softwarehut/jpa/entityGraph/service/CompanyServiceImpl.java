package com.softwarehut.jpa.entityGraph.service;

import com.softwarehut.jpa.entityGraph.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;

@Service
@Primary
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private EntityManager entityManager;

    public Company getCompanyWithDepartments(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    public Company getCompanyWithDepartmentsAndEmployees(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsAndEmployeesGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    public Company getCompanyWithDepartmentsAndEmployeesAndOffices(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsAndEmployeesAndOfficesGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    public Company getCompanyWithCars(Long companyId) {
        EntityGraph<Company> graph = entityManager.createEntityGraph(Company.class);
        graph.addAttributeNodes("cars");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }
}
