package com.emp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.emp.dao.EmployeeRepository;
import com.emp.model.Employee;
 
@Service
@ComponentScan(basePackages={"com.emp.dao"})
public class EmployeeService {
    private static final Logger log = LoggerFactory
            .getLogger(EmployeeService.class);
 
    @Autowired
    EmployeeRepository employeeRepository;
 
    public List<Employee> getAllEmployees() {
        log.info("inside EmployeeService.getAllEmployees");
        return employeeRepository.findAll();
    }
 
    public Employee getEmployeeById(int id) {
        log.info("Getting employee details for ID " + id);
        return employeeRepository.findOne(new Long(id));
    }
 
    public void addEmployee(Employee employee) {
        log.info("Adding Employee " + employee);
        employeeRepository.save(employee);
    }
 
    public void updateEmployee(Employee employee) {
        log.info("Updating Employee " + employee);
        employeeRepository.saveAndFlush(employee);
    }
 
    public void deleteEmployee(int id) {
        log.info("Deleting employee for ID " + id);
        employeeRepository.delete(new Long(id));
    }
 
}
