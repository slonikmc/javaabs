package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.BankOffice;
import tech.reliab.course.ivanovda.bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.List;

public class BankOfficeServiceImpl implements BankOfficeService {

    private final List<BankOffice> bankOffices = new ArrayList<>();

    @Override
    public void createBankOffice(int id, String name, String address, String status, boolean canPlaceAtm, int numberOfAtms,
                                 boolean canIssueLoans, boolean canDispenseCash, boolean canAcceptDeposits, double cashAmount, double rentCost) {
        BankOffice bankOffice = new BankOffice(id, name, address, status, canPlaceAtm, numberOfAtms,
                canIssueLoans, canDispenseCash, canAcceptDeposits, cashAmount, rentCost);
        bankOffices.add(bankOffice);
        System.out.println("Создан новый офис: " + bankOffice);
    }

    @Override
    public void displayBankOfficeInfo(int id) {
        BankOffice bankOffice = findBankOfficeById(id);
        if (bankOffice != null) {
            System.out.println(bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateStatus(int id, String status) {
        BankOffice bankOffice = findBankOfficeById(id);
        if (bankOffice != null) {
            bankOffice.setStatus(status);
            System.out.println("Обновлен статус офиса: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateNumberOfAtms(int id, int numberOfAtms) {
        BankOffice bankOffice = findBankOfficeById(id);
        if (bankOffice != null) {
            bankOffice.setNumberOfAtms(numberOfAtms);
            System.out.println("Обновлено количество банкоматов: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateRentCost(int id, double rentCost) {
        BankOffice bankOffice = findBankOfficeById(id);
        if (bankOffice != null) {
            bankOffice.setRentCost(rentCost);
            System.out.println("Обновлена стоимость аренды: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteBankOffice(int id) {
        BankOffice bankOffice = findBankOfficeById(id);
        if (bankOffice != null) {
            bankOffices.remove(bankOffice);
            System.out.println("Офис удалён: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    // Вспомогательный метод для поиска офиса по ID
    private BankOffice findBankOfficeById(int id) {
        for (BankOffice bankOffice : bankOffices) {
            if (bankOffice.getId() == id) {
                return bankOffice;
            }
        }
        return null;
    }
}
