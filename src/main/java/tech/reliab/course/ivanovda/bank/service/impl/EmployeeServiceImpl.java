package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.Employee;
import tech.reliab.course.ivanovda.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public void createEmployee(
            int id,
            String fullName,
            LocalDate dateOfBirth,
            String position,
            Bank bank,
            boolean worksRemotely,
            String bankOffice,
            boolean canIssueCredits,
            double salary
    ) {
        // Создаём объект сотрудника
        Employee employee = new Employee(
                id,
                fullName,
                dateOfBirth,
                position,
                bank,
                worksRemotely,
                bankOffice,
                canIssueCredits,
                salary
        );
        employees.add(employee);
        System.out.println("Сотрудник создан: \n" + employee);
    }

    @Override
    public void displayEmployeeInfo(int id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateEmployeePosition(int id, String newPosition) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employee.setPosition(newPosition);
            System.out.println("Должность обновлена. Новая должность: " + newPosition);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateEmployeeSalary(int id, double newSalary) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employee.setSalary(newSalary);
            System.out.println("Зарплата обновлена. Новая зарплата: " + newSalary);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Сотрудник с ID " + id + " удалён.");
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    // Вспомогательный метод для поиска сотрудника по ID
    private Employee findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
