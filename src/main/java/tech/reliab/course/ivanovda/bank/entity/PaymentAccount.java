package tech.reliab.course.ivanovda.bank.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_accounts")
public class PaymentAccount {
    // Id платежного счета
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Пользователь, владелец счета
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    // Банк, в котором открыт счет
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    // Сумма на счету (по умолчанию 0)
    private double balance;

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Баланс не может быть отрицательным.");
        }
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", bankName='" + bank + '\'' +
                ", balance=" + balance +
                '}';
    }
}
