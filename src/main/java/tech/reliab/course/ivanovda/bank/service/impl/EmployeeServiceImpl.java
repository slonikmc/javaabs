package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.Employee;
import tech.reliab.course.ivanovda.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee;

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
        employee = new Employee(
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
        System.out.println("Сотрудник создан: \n" + employee);
    }

    @Override
    public void displayEmployeeInfo(int id) {
        if (employee != null && employee.getId() == id) {
            System.out.println(employee);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateEmployeePosition(int id, String newPosition) {
        if (employee != null && employee.getId() == id) {
            employee.setPosition(newPosition);
            System.out.println("Должность обновлена. Новая должность: " + newPosition);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateEmployeeSalary(int id, double newSalary) {
        if (employee != null && employee.getId() == id) {
            employee.setSalary(newSalary);
            System.out.println("Зарплата обновлена. Новая зарплата: " + newSalary);
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (employee != null && employee.getId() == id) {
            employee = null;
            System.out.println("Сотрудник с ID " + id + " удалён.");
        } else {
            System.out.println("Сотрудник с ID " + id + " не найден.");
        }
    }
}
