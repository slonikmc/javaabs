package tech.reliab.course.ivanovda.bank.entity;

import java.time.LocalDate;

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

    // Конструктор
    public Employee(int id, String fullName, LocalDate dateOfBirth, String position, Bank bankName,
                    boolean worksRemotely, String bankOffice, boolean canIssueLoans, double salary) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.bank = bankName;
        this.worksRemotely = worksRemotely;
        this.bankOffice = bankOffice;
        this.canIssueCredits = canIssueCredits;
        this.salary = salary;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean isWorksRemotely() {
        return worksRemotely;
    }

    public String getBankOffice() {
        return bankOffice;
    }

    public boolean isCanIssueCredits() {
        return canIssueCredits;
    }

    public double getSalary() {
        return salary;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setWorksRemotely(boolean worksRemotely) {
        this.worksRemotely = worksRemotely;
    }

    public void setBankOffice(String bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setCanIssueCredits(boolean canIssueCredits) {
        this.canIssueCredits = canIssueCredits;
    }

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
