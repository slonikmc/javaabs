package tech.reliab.course.ivanovda.bank.entity;

public class PaymentAccount {
    // Id платежного счета
    private int id;
    // Пользователь, владелец счета
    private User user;
    // Банк, в котором открыт счет
    private Bank bank;
    // Сумма на счету (по умолчанию 0)
    private double balance;

    // Конструкторы
    public PaymentAccount(int id, User user, Bank bankName, double balance) {
        this.id = id;
        this.user = user;
        this.bank = bankName;
        this.balance = Math.max(balance, 0);
    }


    public PaymentAccount(int id, User user, Bank bankName) {
        this(id, user, bankName, 0);
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

    public double getBalance() {
        return balance;
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
