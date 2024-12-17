package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    void updateEmployee(int id, Employee updatedEmployee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);
    /**
     * Удаляет сотрудника с заданным идентификатором.
     *
     * @param id идентификатор сотрудника
     */
    void deleteEmployee(int id);
}
