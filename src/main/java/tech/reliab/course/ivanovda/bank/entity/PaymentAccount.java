package tech.reliab.course.ivanovda.bank.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccount {
    // Id платежного счета
    private int id;
    // Пользователь, владелец счета
    private User user;
    // Банк, в котором открыт счет
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
