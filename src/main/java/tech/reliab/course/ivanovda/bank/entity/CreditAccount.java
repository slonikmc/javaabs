package tech.reliab.course.ivanovda.bank.entity;

import java.time.LocalDate;

public class CreditAccount {

    private int id;
    private User user;
    private Bank bank;
    private LocalDate startDate;
    private LocalDate endDate;
    private int creditMonths;
    private double creditAmount;
    private double monthlyPayment;
    private double interestRate;
    private Employee employee;
    private PaymentAccount paymentAccount;

    // Конструктор
    public CreditAccount(int id, User user, Bank bankName, LocalDate startDate, int creditMonths,
                         double creditAmount, double interestRate, Employee employee, PaymentAccount paymentAccount) {
        this.id = id;
        this.user = user;
        this.bank = bankName;
        this.startDate = startDate;
        this.creditMonths = creditMonths;
        this.creditAmount = creditAmount;
        this.interestRate = interestRate;
        this.employee = employee;
        this.paymentAccount = paymentAccount;

        // Вычисляем дату окончания кредита и ежемесячный платеж
        this.endDate = calculateEndDate(startDate, creditMonths);
        this.monthlyPayment = calculateMonthlyPayment(creditAmount, interestRate, creditMonths);
    }

    // Метод для вычисления даты окончания кредита
    private LocalDate calculateEndDate(LocalDate startDate, int months) {
        return startDate.plusMonths(months);
    }

    // Метод для вычисления ежемесячного платежа
    private double calculateMonthlyPayment(double creditAmount, double interestRate, int months) {
        double monthlyRate = interestRate / 100 / 12; // Процентная ставка в месяц
        return (creditAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getCreditMonths() {
        return creditMonths;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        this.endDate = calculateEndDate(startDate, creditMonths);
    }

    public void setCreditMonths(int creditMonths) {
        this.creditMonths = creditMonths;
        this.endDate = calculateEndDate(startDate, creditMonths);
        this.monthlyPayment = calculateMonthlyPayment(creditAmount, interestRate, creditMonths);
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
        this.monthlyPayment = calculateMonthlyPayment(creditAmount, interestRate, creditMonths);
    }

    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
            this.monthlyPayment = calculateMonthlyPayment(creditAmount, interestRate, creditMonths);
        } else {
            throw new IllegalArgumentException("Процентная ставка не может быть отрицательной.");
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", bankName='" + bank + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", creditMonths=" + creditMonths +
                ", creditAmount=" + creditAmount +
                ", monthlyPayment=" + monthlyPayment +
                ", interestRate=" + interestRate +
                ", employee=" + employee +
                ", paymentAccount=" + paymentAccount +
                '}';
    }
}

