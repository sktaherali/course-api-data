package taher.io.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import taher.io.entity.Employee;
import taher.io.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping( "/getreply")
	public String getreply() {
		
		return "dddd";
	}
	@PostMapping( "/allEmployee")
	public List<Employee> getAllEmployee( @RequestBody  Map <String, String> params) {
		
		return employeeService.getAllEmployee(params);
	}
	
	
	@PostMapping("/createEmployee")
	public Employee createNewEmployee( @RequestBody Employee emplayee) {
		
		return employeeService.saveEmployee(emplayee); 
	}

}
