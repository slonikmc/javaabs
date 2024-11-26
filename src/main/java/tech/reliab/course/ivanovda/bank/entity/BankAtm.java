package tech.reliab.course.ivanovda.bank.entity;

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

    // Конструктор
    public BankAtm(int id, String name, String address, String status, Bank bank, boolean locatedInOffice,
                   String servicingEmployee, boolean canDispenseCash, boolean canAcceptDeposits, double cashAmount,
                   double maintenanceCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.locatedInOffice = locatedInOffice;
        this.servicingEmployee = servicingEmployee;
        this.canDispenseCash = canDispenseCash;
        this.canAcceptDeposits = canAcceptDeposits;
        this.cashAmount = cashAmount;
        this.maintenanceCost = maintenanceCost;
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

    public Bank getBank() {
        return bank;
    }

    public boolean isLocatedInOffice() {
        return locatedInOffice;
    }

    public String getServicingEmployee() {
        return servicingEmployee;
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

    public double getMaintenanceCost() {
        return maintenanceCost;
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
        if (status.equals("Работает") || status.equals("Не работает") || status.equals("Нет денег")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Недопустимый статус. Допустимые значения: Работает, Не работает, Нет денег.");
        }
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setLocatedInOffice(boolean locatedInOffice) {
        this.locatedInOffice = locatedInOffice;
    }

    public void setServicingEmployee(String servicingEmployee) {
        this.servicingEmployee = servicingEmployee;
    }

    public void setCanDispenseCash(boolean canDispenseCash) {
        this.canDispenseCash = canDispenseCash;
    }

    public void setCanAcceptDeposits(boolean canAcceptDeposits) {
        this.canAcceptDeposits = canAcceptDeposits;
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
