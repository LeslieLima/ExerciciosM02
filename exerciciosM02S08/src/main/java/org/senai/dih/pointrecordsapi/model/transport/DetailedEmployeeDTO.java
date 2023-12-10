package org.senai.dih.pointrecordsapi.model.transport;

import org.senai.dih.pointrecordsapi.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public record DetailedEmployeeDTO(Long id, String name, String office, BigDecimal wage, List<PointRecordDTO> records) {

    public DetailedEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage(), employee.getPointRecordsAsObject());
    }
}
