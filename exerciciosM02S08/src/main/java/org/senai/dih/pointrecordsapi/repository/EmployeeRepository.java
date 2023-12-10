package org.senai.dih.pointrecordsapi.repository;

import org.senai.dih.pointrecordsapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
