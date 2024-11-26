package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.BankOffice;
import tech.reliab.course.ivanovda.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {

    private BankOffice bankOffice;

    @Override
    public void createBankOffice(int id, String name, String address, String status, boolean canPlaceAtm, int numberOfAtms,
                                 boolean canIssueLoans, boolean canDispenseCash, boolean canAcceptDeposits, double cashAmount, double rentCost) {
        bankOffice = new BankOffice(id, name, address, status, canPlaceAtm, numberOfAtms,
                canIssueLoans, canDispenseCash, canAcceptDeposits, cashAmount, rentCost);
        System.out.println("Создан новый офис: " + bankOffice);
    }

    @Override
    public void displayBankOfficeInfo(int id) {
        if (bankOffice != null && bankOffice.getId() == id) {
            System.out.println(bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateStatus(int id, String status) {
        if (bankOffice != null && bankOffice.getId() == id) {
            bankOffice.setStatus(status);
            System.out.println("Обновлен статус офиса: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateNumberOfAtms(int id, int numberOfAtms) {
        if (bankOffice != null && bankOffice.getId() == id) {
            bankOffice.setNumberOfAtms(numberOfAtms);
            System.out.println("Обновлено количество банкоматов: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateRentCost(int id, double rentCost) {
        if (bankOffice != null && bankOffice.getId() == id) {
            bankOffice.setRentCost(rentCost);
            System.out.println("Обновлена стоимость аренды: " + bankOffice);
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteBankOffice(int id) {
        if (bankOffice != null && bankOffice.getId() == id) {
            System.out.println("Офис удален: " + bankOffice);
            bankOffice = null;
        } else {
            System.out.println("Офис с ID " + id + " не найден.");
        }
    }
}
