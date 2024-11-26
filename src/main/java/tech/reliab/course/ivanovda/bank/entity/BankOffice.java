package tech.reliab.course.ivanovda.bank.entity;

public class BankOffice {
    // id офиса
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

    // Конструктор
    public BankOffice(int id, String name, String address, String status, boolean canPlaceAtm, int numberOfAtms,
                      boolean canIssueLoans, boolean canDispenseCash, boolean canAcceptDeposits, double cashAmount, double rentCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.canPlaceAtm = canPlaceAtm;
        this.numberOfAtms = numberOfAtms;
        this.canIssueLoans = canIssueLoans;
        this.canDispenseCash = canDispenseCash;
        this.canAcceptDeposits = canAcceptDeposits;
        this.cashAmount = cashAmount;
        this.rentCost = rentCost;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public boolean isCanPlaceAtm() {
        return canPlaceAtm;
    }

    public int getNumberOfAtms() {
        return numberOfAtms;
    }

    public boolean isCanIssueLoans() {
        return canIssueLoans;
    }

    public boolean isCanDispenseCash() {
        return canDispenseCash;
    }

    public boolean isCanAcceptDeposits() {
        return canAcceptDeposits;
    }

    public double getCashAmount() {
        return cashAmount;
    }

    public double getRentCost() {
        return rentCost;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        if (status.equals("Работает") || status.equals("Не работает")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Недопустимый статус. Допустимые значения: Работает, Не работает.");
        }
    }

    public void setCanPlaceAtm(boolean canPlaceAtm) {
        this.canPlaceAtm = canPlaceAtm;
    }

    public void setNumberOfAtms(int numberOfAtms) {
        if (numberOfAtms >= 0) {
            this.numberOfAtms = numberOfAtms;
        } else {
            throw new IllegalArgumentException("Количество банкоматов не может быть отрицательным.");
        }
    }

    public void setCanIssueLoans(boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    public void setCanDispenseCash(boolean canDispenseCash) {
        this.canDispenseCash = canDispenseCash;
    }

    public void setCanAcceptDeposits(boolean canAcceptDeposits) {
        this.canAcceptDeposits = canAcceptDeposits;
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
