package com.softwarehut.jpa.entityGraph.service;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.softwarehut.jpa.entityGraph.model.Company;

@Service(value = "companyServiceEntityGraph")
public class CompanyServiceEntityGraphImpl implements CompanyService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company getCompanyWithDepartments(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    @Override
    public Company getCompanyWithDepartmentsAndEmployees(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsAndEmployeesGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    @Override
    public Company getCompanyWithDepartmentsAndEmployeesAndOffices(Long companyId) {
        EntityGraph graph = entityManager.getEntityGraph("companyWithDepartmentsAndEmployeesAndOfficesGraph");
        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }

    @Override
    public Company getCompanyWithCars(Long companyId) {
        EntityGraph<Company> graph = entityManager.createEntityGraph(Company.class);
        graph.addAttributeNodes("cars");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", graph);

        return entityManager.find(Company.class, companyId, hints);
    }
}
