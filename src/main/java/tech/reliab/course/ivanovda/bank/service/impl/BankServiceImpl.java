package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.service.BankService;
import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {
    private Bank bank; // Экземпляр банка для управления

    @Override
    public Bank createBank(int id, String name) {
        if (this.bank == null) {
            this.bank = new Bank(id, name);
            System.out.println("Банк успешно создан: " + this.bank);
        } else {
            System.out.println("Банк уже существует. Повторное создание невозможно.");
        }
        return this.bank;
    }

    @Override
    public Bank getBank() {
        if (this.bank == null) {
            throw new IllegalStateException("Банк еще не создан.");
        }
        return this.bank;
    }

    @Override
    public void updateBankName(String name) {
        if (this.bank != null) {
            this.bank.setName(name);
            System.out.println("Название банка обновлено: " + name);
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void updateBankRating(int rating) {
        if (this.bank != null) {
            try {
                this.bank.setRating(rating);
                System.out.println("Рейтинг банка обновлен: " + rating);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void updateTotalCash(double totalCash) {
        if (this.bank != null) {
            try {
                this.bank.setTotalCash(totalCash);
                System.out.println("Общая сумма денег в банке обновлена: " + totalCash);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void incrementOffices() {
        if (this.bank != null) {
            this.bank.addOffice();
            System.out.println("Количество офисов увеличено. Текущее количество: " + this.bank.getNumberOfOffices());
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void incrementATMs() {
        if (this.bank != null) {
            this.bank.addAtm();
            System.out.println("Количество банкоматов увеличено. Текущее количество: " + this.bank.getNumberOfATMs());
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void incrementEmployees() {
        if (this.bank != null) {
            this.bank.addEmployee();
            System.out.println("Количество сотрудников увеличено. Текущее количество: " + this.bank.getNumberOfEmployees());
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void incrementClients() {
        if (this.bank != null) {
            this.bank.addClient();
            System.out.println("Количество клиентов увеличено. Текущее количество: " + this.bank.getNumberOfClients());
        } else {
            System.out.println("Банк еще не создан.");
        }
    }

    @Override
    public void displayBankInfo() {
        if (this.bank != null) {
            System.out.println("Информация о банке: " + this.bank);
        } else {
            System.out.println("Банк еще не создан.");
        }
    }
}
