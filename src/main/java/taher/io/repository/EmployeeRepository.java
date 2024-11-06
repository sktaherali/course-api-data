package taher.io.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import taher.io.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	
	 List<Employee> findAll() ;

	 @Cacheable(value = "employee", key = "{#userNameSearchStartsWith, #pageable.sort, #pageable.pageSize, #pageable.pageNumber}")
	 @Query("select e from Employee e where e.name like concat(:userNameSearchStartsWith, '%')")
	 Page<Employee> findAll(Pageable pageable, String userNameSearchStartsWith);

}
