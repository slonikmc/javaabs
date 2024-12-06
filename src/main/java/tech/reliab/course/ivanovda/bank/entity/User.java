package tech.reliab.course.ivanovda.bank.entity;

import java.time.LocalDate;
import java.util.Random;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // Id клиента
    private int id;
    // ФИО
    private String fullName;
    // Дата рождения
    private LocalDate dateOfBirth;
    // Место работы
    private String workplace;
    // Ежемесячный доход
    private double monthlyIncome;
    // Банк, которым пользуется
    private Bank bank;
    // Кредитный счет
    private CreditAccount creditAccount;
    // Платежный счет
    private PaymentAccount paymentAccount;
    // Кредитный рейтинг
    private int creditRating;

    // Конструктор
    public User(int id, String fullName, LocalDate dateOfBirth, String workplace) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.workplace = workplace;
        this.monthlyIncome = generateRandomIncome();
        this.bank = null;
        this.creditAccount = null;
        this.paymentAccount = null;
        this.creditRating = calculateCreditRating();
    }

    // Метод генерации случайного дохода
    private double generateRandomIncome() {
        Random random = new Random();
        return 1000 + random.nextInt(9001); // От 1000 до 10000
    }

    // Метод для расчета кредитного рейтинга
    private int calculateCreditRating() {
        return (int) (monthlyIncome / 1000) * 100;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        if (monthlyIncome >= 0 && monthlyIncome <= 10000) {
            this.monthlyIncome = monthlyIncome;
            this.creditRating = calculateCreditRating();
        } else {
            throw new IllegalArgumentException("Ежемесячный доход должен быть от 0 до 10 000.");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", workplace='" + workplace + '\'' +
                ", monthlyIncome=" + monthlyIncome +
                ", bank='" + bank + '\'' +
                ", creditAccount=" + creditAccount +
                ", paymentAccount=" + paymentAccount +
                ", creditRating=" + creditRating +
                '}';
    }
}
