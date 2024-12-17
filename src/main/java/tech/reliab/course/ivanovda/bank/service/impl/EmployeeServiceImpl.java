package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.Employee;
import tech.reliab.course.ivanovda.bank.repository.EmployeeRepository;
import tech.reliab.course.ivanovda.bank.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
        System.out.println("Сотрудник создан: " + employee);
    }

    @Override
    public void updateEmployee(int id, Employee updatedEmployee) {
        if (employeeRepository.existsById(id)) {
            Employee employee = employeeRepository.findById(id).get();
            employee.setFullName(updatedEmployee.getFullName());
            employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            employee.setPosition(updatedEmployee.getPosition());
            employee.setBank(updatedEmployee.getBank());
            employee.setWorksRemotely(updatedEmployee.isWorksRemotely());
            employee.setBankOffice(updatedEmployee.getBankOffice());
            employee.setCanIssueCredits(updatedEmployee.isCanIssueCredits());
            employee.setSalary(updatedEmployee.getSalary());
            employeeRepository.save(employee);
            System.out.println("Данные сотрудника обновлены: " + employee);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            System.out.println("Сотрудник с ID " + id + " удалён.");
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }
}
