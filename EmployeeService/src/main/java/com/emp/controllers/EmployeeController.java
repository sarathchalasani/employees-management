package com.emp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/employees" })
public class EmployeeController {

	@Autowired
    EmployeeService service;
	
	@GetMapping(path="/viewemployees",produces = "application/json")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable("id") int id) {
		service.deleteEmployee(id);
	}

	@PostMapping
	public void create(@RequestBody Employee employee) {
		service.addEmployee(employee);
	}
}