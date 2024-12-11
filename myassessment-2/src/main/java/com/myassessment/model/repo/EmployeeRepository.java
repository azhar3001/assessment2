package com.myassessment.model.repo;

import com.myassessment.model.data.EmployeeListDto;
import com.myassessment.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    @Query("SELECT new com.myassessment.model.data.EmployeeListDto(e.firstName, e.lastName, e.email,e.jobTitle) FROM Employee e")
    List<EmployeeListDto> findAllEmployee();


    @Query("SELECT new com.myassessment.model.data.EmployeeListDto(e.firstName, e.lastName, e.email,e.jobTitle) FROM Employee e")
    Page<EmployeeListDto> findAllEmployeeByPage(Pageable pageable);
}