package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;
import tech.reliab.course.ivanovda.bank.service.AtmService;

import java.util.ArrayList;
import java.util.List;

public class AtmServiceImpl implements AtmService {
    private final List<BankAtm> atmList = new ArrayList<>();

    @Override
    public void createAtm(int id, String name, String address, String status, Bank bank, boolean locatedInOffice,
                          String servicingEmployee, boolean canDispenseCash, boolean canAcceptDeposits,
                          double cashAmount, double maintenanceCost) {
        BankAtm atm = new BankAtm(id, name, address, status, bank, locatedInOffice, servicingEmployee,
                canDispenseCash, canAcceptDeposits, cashAmount, maintenanceCost);
        atmList.add(atm);
        System.out.println("Банкомат создан: " + atm);
    }

    @Override
    public void updateStatus(int id, String newStatus) {
        BankAtm atm = findAtmById(id);
        if (atm != null) {
            atm.setStatus(newStatus);
            System.out.println("Статус банкомата обновлен: " + atm.getStatus());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCashAmount(int id, double newCashAmount) {
        BankAtm atm = findAtmById(id);
        if (atm != null) {
            atm.setCashAmount(newCashAmount);
            System.out.println("Количество денег в банкомате обновлено: " + atm.getCashAmount());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateMaintenanceCost(int id, double newMaintenanceCost) {
        BankAtm atm = findAtmById(id);
        if (atm != null) {
            atm.setMaintenanceCost(newMaintenanceCost);
            System.out.println("Стоимость обслуживания банкомата обновлена: " + atm.getMaintenanceCost());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void displayAtmInfo() {
        if (atmList.isEmpty()) {
            System.out.println("Банкоматы отсутствуют.");
        } else {
            System.out.println("Список банкоматов:");
            for (BankAtm atm : atmList) {
                System.out.println(atm);
            }
        }
    }

    @Override
    public void deleteAtm(int id) {
        BankAtm atm = findAtmById(id);
        if (atm != null) {
            atmList.remove(atm);
            System.out.println("Банкомат с ID " + id + " удалён.");
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    // Вспомогательный метод для поиска банкомата по ID
    private BankAtm findAtmById(int id) {
        for (BankAtm atm : atmList) {
            if (atm.getId() == id) {
                return atm;
            }
        }
        return null;
    }
}
