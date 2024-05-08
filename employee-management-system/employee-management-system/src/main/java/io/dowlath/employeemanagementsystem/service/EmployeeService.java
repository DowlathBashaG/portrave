package io.dowlath.employeemanagementsystem.service;

import io.dowlath.employeemanagementsystem.dto.EmployeeDto;
import io.dowlath.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
