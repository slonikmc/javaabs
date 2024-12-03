package tech.reliab.course.ivanovda.bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAtm {
    // id банкомата
    private int id;
    // Название банкомата
    private String name;
    // Адрес
    private String address;
    // Статус банкомата (работает/не работает/нет денег)
    private String status;
    // Банк, которому принадлежит банкомат
    private Bank bank;
    // Расположен ли банкомат в банковском офисе
    private boolean locatedInOffice;
    // Обслуживающий сотрудник
    private String servicingEmployee;
    // Работает ли на выдачу денег
    private boolean canDispenseCash;
    // Можно ли внести деньги
    private boolean canAcceptDeposits;
    // Количество денег в банкомате
    private double cashAmount;
    // Стоимость обслуживания банкомата
    private double maintenanceCost;

    public void setStatus(String status) {
        if (status.equals("Работает") || status.equals("Не работает") || status.equals("Нет денег")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Недопустимый статус. Допустимые значения: Работает, Не работает, Нет денег.");
        }
    }

    public void setCashAmount(double cashAmount) {
        if (cashAmount >= 0 && cashAmount <= (bank != null ? bank.getTotalCash() : Double.MAX_VALUE)) {
            this.cashAmount = cashAmount;
        } else {
            throw new IllegalArgumentException("Количество денег в банкомате превышает доступные средства банка.");
        }
    }

    public void setMaintenanceCost(double maintenanceCost) {
        if (maintenanceCost >= 0) {
            this.maintenanceCost = maintenanceCost;
        } else {
            throw new IllegalArgumentException("Стоимость обслуживания не может быть отрицательной.");
        }
    }

    @Override
    public String toString() {
        return "BankAtm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", bank=" + (bank != null ? bank.getName() : "Не указан") +
                ", locatedInOffice=" + locatedInOffice +
                ", servicingEmployee='" + servicingEmployee + '\'' +
                ", canDispenseCash=" + canDispenseCash +
                ", canAcceptDeposits=" + canAcceptDeposits +
                ", cashAmount=" + cashAmount +
                ", maintenanceCost=" + maintenanceCost +
                '}';
    }
}
