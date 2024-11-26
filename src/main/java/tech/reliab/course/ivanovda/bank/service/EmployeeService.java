package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.Employee;

import java.time.LocalDate;

public interface EmployeeService {

    /**
     * Создает нового сотрудника с заданным идентификатором, полным именем, датой рождения, должностью и другими параметрами.
     *
     * @param id               идентификатор сотрудника
     * @param fullName         полное имя сотрудника
     * @param dateOfBirth      дата рождения сотрудника
     * @param position         должность сотрудника
     * @param bank             банк, в котором работает сотрудник
     * @param worksRemotely    индикатор, работает ли сотрудник удаленно
     * @param bankOffice       офис, в котором работает сотрудник
     * @param canIssueCredits  может ли сотрудник выдавать кредиты
     * @param salary           зарплата сотрудника
     */
    void createEmployee(int id, String fullName, LocalDate dateOfBirth, String position, Bank bank,
                        boolean worksRemotely, String bankOffice, boolean canIssueCredits, double salary);

    /**
     * Выводит информацию о сотруднике с заданным идентификатором.
     *
     * @param id идентификатор сотрудника
     */
    void displayEmployeeInfo(int id);

    /**
     * Обновляет должность сотрудника.
     *
     * @param id           идентификатор сотрудника
     * @param newPosition  новая должность сотрудника
     */
    void updateEmployeePosition(int id, String newPosition);

    /**
     * Обновляет зарплату сотрудника.
     *
     * @param id        идентификатор сотрудника
     * @param newSalary новая зарплата сотрудника
     */
    void updateEmployeeSalary(int id, double newSalary);

    /**
     * Удаляет сотрудника с заданным идентификатором.
     *
     * @param id идентификатор сотрудника
     */
    void deleteEmployee(int id);
}
