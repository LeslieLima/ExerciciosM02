package org.senai.dih.pointrecordsapi.model.transport;

import org.senai.dih.pointrecordsapi.model.Employee;

import java.math.BigDecimal;

public record GeneralEmployeeDTO(Long id, String name, String office, BigDecimal wage) {

    public GeneralEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage());
    }
}
