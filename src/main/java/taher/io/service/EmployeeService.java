package taher.io.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import taher.io.entity.Employee;
import taher.io.exception.BadRequestException;
import taher.io.repository.EmployeeRepository;

@Service
public class EmployeeService { 
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Cacheable(value = "emplayee", key="'allEmployees'")
	public List<Employee> getAllEmployee() {
		
		List<Employee> emList = employeeRepository.findAll();
		
		return emList;
		
	}
	
	public List<Employee> getAllEmployee(Map<String, String> params) {
		
		int page = 0;
		int size = 10;
		String sortBy = "name";
		String order = "asc";
		String userNameSearchStartsWith = "";
		if(params.containsKey("sortBy") && !"".equals(params.get("sortBy")) ) {
			sortBy = params.get("sortBy");
		}
		if(params.containsKey("page") && !"".equals(params.get("page")) ) {
			page = Integer.valueOf(params.get("page")) ;
		}
		if(params.containsKey("size") && !"".equals(params.get("size")) ) {
			size = Integer.valueOf(params.get("size")) ;
		}
		
		if(params.containsKey("search") && !"".equals(params.get("search")) ) {
			userNameSearchStartsWith = params.get("search");
		}
		if(params.containsKey("order") && !"".equals(params.get("order")) ) {
			order = params.get("order");
		}
			
	        Sort sort = "desc".equalsIgnoreCase(order) ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
			
			Pageable pageable = PageRequest.of(page, size, sort);
		
		Page<Employee> emList = employeeRepository.findAll(pageable,userNameSearchStartsWith);
		
		return emList.getContent();
		
	}
	@CacheEvict(value = "emplayee", allEntries = true)
	public Employee saveEmployee( Employee emplayee) {
		
		return employeeRepository.save(emplayee);
		
	}
	
}
