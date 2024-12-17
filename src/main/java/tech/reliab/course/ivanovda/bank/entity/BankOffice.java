package tech.reliab.course.ivanovda.bank.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_offices")
public class BankOffice {
    // id офиса
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Имя отделеления
    private String name;
    // Адрес отделения банка
    private String address;
    // Статус отделения (работает/не работает)
    private String status;
    // Можно ли разместить банкомат
    private boolean canPlaceAtm;
    // Количество банкоматов в офисе
    private int numberOfAtms;
    // Можно ли оформить кредит
    private boolean canIssueLoans;
    // Работает ли на выдачу денег
    private boolean canDispenseCash;
    // Можно ли внести деньги
    private boolean canAcceptDeposits;
    // Количество денег в офисе
    private double cashAmount;
    // Стоимость аренды офиса
    private double rentCost;


    public void setStatus(String status) {
        if (status.equals("Работает") || status.equals("Не работает")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Недопустимый статус. Допустимые значения: Работает, Не работает.");
        }
    }

    public void setNumberOfAtms(int numberOfAtms) {
        if (numberOfAtms >= 0) {
            this.numberOfAtms = numberOfAtms;
        } else {
            throw new IllegalArgumentException("Количество банкоматов не может быть отрицательным.");
        }
    }

    public void setCashAmount(double cashAmount) {
        if (cashAmount >= 0) {
            this.cashAmount = cashAmount;
        } else {
            throw new IllegalArgumentException("Количество денег не может быть отрицательным.");
        }
    }

    public void setRentCost(double rentCost) {
        if (rentCost >= 0) {
            this.rentCost = rentCost;
        } else {
            throw new IllegalArgumentException("Стоимость аренды не может быть отрицательной.");
        }
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", canPlaceAtm=" + canPlaceAtm +
                ", numberOfAtms=" + numberOfAtms +
                ", canIssueLoans=" + canIssueLoans +
                ", canDispenseCash=" + canDispenseCash +
                ", canAcceptDeposits=" + canAcceptDeposits +
                ", cashAmount=" + cashAmount +
                ", rentCost=" + rentCost +
                '}';
    }
}
