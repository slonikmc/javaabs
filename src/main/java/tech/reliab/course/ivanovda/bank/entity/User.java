package tech.reliab.course.ivanovda.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Random;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    // Id клиента
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // ФИО
    @Column(name = "full_name", nullable = false)
    private String fullName;
    // Дата рождения
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    // Место работы
    @Column(name = "workplace")
    private String workplace;
    // Ежемесячный доход
    @Column(name = "monthly_income", nullable = false)
    private double monthlyIncome;
    // Банк, которым пользуется
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    // Кредитный счет
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_account_id")
    private CreditAccount creditAccount;
    // Платежный счет
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_account_id")
    private PaymentAccount paymentAccount;
    // Кредитный рейтинг
    @Column(name = "credit_rating", nullable = false)
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
