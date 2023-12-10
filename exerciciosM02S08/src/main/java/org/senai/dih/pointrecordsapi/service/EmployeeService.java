package org.senai.dih.pointrecordsapi.service;

import jakarta.transaction.Transactional;
import org.senai.dih.pointrecordsapi.model.Employee;
import org.senai.dih.pointrecordsapi.model.PointRecord;
import org.senai.dih.pointrecordsapi.model.transport.*;
import org.senai.dih.pointrecordsapi.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public GeneralEmployeeDTO create(CreateEmployeeDTO body) {
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new GeneralEmployeeDTO(newEmployee);
    }

    @Transactional
    public PointRecordDTO createPointRecord(Long id, CreatePointRecordDTO body) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        PointRecord pointRecord = new PointRecord(body.type(), employee);
        employee.getPointRecords().add(pointRecord);

        return new PointRecordDTO(pointRecord);
    }

    public Page<GeneralEmployeeDTO> listAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable).map(GeneralEmployeeDTO::new);
    }

    public DetailedEmployeeDTO getEmployee(Long id) {
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));
    }
}
