package tech.reliab.course.ivanovda.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_accounts")
public class CreditAccount {

    // id Аккаунта
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Клиент, чей аккаунт
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Банк, где зарегистрирован аккаунт
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    // Дата начала кредита
    private LocalDate startDate;
    // Дата конца кредита
    private LocalDate endDate;
    // Сколько месяцев выплачивать
    private int creditMonths;
    // Размер кредита
    private double creditAmount;
    // Месячный платеж
    private double monthlyPayment;
    // Ставка
    private double interestRate;
    // Сотрудник
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    // Связанный платежный счет
    @ManyToOne
    @JoinColumn(name = "payment_account_id")
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

