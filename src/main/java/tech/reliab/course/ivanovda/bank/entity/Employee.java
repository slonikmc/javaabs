package tech.reliab.course.ivanovda.bank.entity;

import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    // Id сотрудника
    private int id;
    // ФИО
    private String fullName;
    // Дата рождения
    private LocalDate dateOfBirth;
    // Должность
    private String position;
    // Банк, где работает сотрудник
    private Bank bank;
    // Работает ли удаленно
    private boolean worksRemotely;
    // Офис, в котором работает сотрудник
    private String bankOffice;
    // Может ли выдавать кредиты
    private boolean canIssueCredits;
    // Размер зарплаты
    private double salary;

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", position='" + position + '\'' +
                ", bankName='" + bank + '\'' +
                ", worksRemotely=" + worksRemotely +
                ", bankOffice='" + bankOffice + '\'' +
                ", canIssueCredits=" + canIssueCredits +
                ", salary=" + salary +
                '}';
    }
}
