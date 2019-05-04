package com.emp.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.emp.model.Employee;
import com.emp.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	
	 @InjectMocks
	 EmployeeController employeeController;
	 
    @Mock
    EmployeeService employeeService;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllEmployeeTest(){
    	List<Employee> list = new ArrayList<Employee>();
    	Employee empOne = new Employee(1L, "John", "Johnlast", "IT",new Date(),"Male");
    	 list.add(empOne);
    	when(employeeService.getAllEmployees()).thenReturn(list);
    	List<Employee> empList = employeeController.getAllEmployees();
        assertEquals(1, empList.size());
        verify(employeeService, times(1)).getAllEmployees();
    }
    
    @Test
    public void createEmployeeTest(){
    	Employee employee=new Employee();
    	employeeController.create(employee);
    	verify(employeeService, times(1)).addEmployee(employee);
    }
	
}