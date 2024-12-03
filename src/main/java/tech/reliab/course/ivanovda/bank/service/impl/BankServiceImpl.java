package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.service.BankService;

import java.util.ArrayList;
import java.util.List;

public class BankServiceImpl implements BankService {

    private final List<Bank> banks = new ArrayList<>();

    @Override
    public Bank createBank(int id, String name) {
        Bank bank = new Bank(id, name);
        banks.add(bank);
        System.out.println("Банк успешно создан: " + bank);
        return bank;
    }

    @Override
    public Bank getBank() {
        if (banks.isEmpty()) {
            throw new IllegalStateException("Банков пока нет.");
        }
        return banks.get(0);
    }

    @Override
    public void updateBankName(String name) {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                bank.setName(name);
                System.out.println("Название банка обновлено: " + name + " для банка с ID: " + bank.getId());
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void updateBankRating(int rating) {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                try {
                    bank.setRating(rating);
                    System.out.println("Рейтинг банка обновлен: " + rating + " для банка с ID: " + bank.getId());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void updateTotalCash(double totalCash) {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                try {
                    bank.setTotalCash(totalCash);
                    System.out.println("Общая сумма денег обновлена: " + totalCash + " для банка с ID: " + bank.getId());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void incrementOffices() {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                bank.addOffice();
                System.out.println("Количество офисов увеличено. Текущее количество офисов: " + bank.getNumberOfOffices() + " для банка с ID: " + bank.getId());
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void incrementATMs() {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                bank.addAtm();
                System.out.println("Количество банкоматов увеличено. Текущее количество банкоматов: " + bank.getNumberOfATMs() + " для банка с ID: " + bank.getId());
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void incrementEmployees() {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                bank.addEmployee();
                System.out.println("Количество сотрудников увеличено. Текущее количество сотрудников: " + bank.getNumberOfEmployees() + " для банка с ID: " + bank.getId());
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void incrementClients() {
        if (!banks.isEmpty()) {
            for (Bank bank : banks) {
                bank.addClient();
                System.out.println("Количество клиентов увеличено. Текущее количество клиентов: " + bank.getNumberOfClients() + " для банка с ID: " + bank.getId());
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }

    @Override
    public void displayBankInfo() {
        if (!banks.isEmpty()) {
            System.out.println("Информация о банках:");
            for (Bank bank : banks) {
                System.out.println(bank);
            }
        } else {
            System.out.println("Банков пока нет.");
        }
    }
}
