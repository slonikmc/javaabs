package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;
import tech.reliab.course.ivanovda.bank.service.AtmService;
import java.util.ArrayList;
import java.util.List;

public class AtmServiceImpl implements AtmService {
    private BankAtm atm; // Единственный экземпляр банкомата для управления

    @Override
    public void createAtm(int id, String name, String address, String status, Bank bank, boolean locatedInOffice,
                          String servicingEmployee, boolean canDispenseCash, boolean canAcceptDeposits,
                          double cashAmount, double maintenanceCost) {
        atm = new BankAtm(id, name, address, status, bank, locatedInOffice, servicingEmployee,
                canDispenseCash, canAcceptDeposits, cashAmount, maintenanceCost);
        System.out.println("Банкомат создан: " + atm);
    }

    @Override
    public void updateStatus(int id, String newStatus) {
        if (atm != null && atm.getId() == id) {
            atm.setStatus(newStatus);
            System.out.println("Статус банкомата обновлен: " + atm.getStatus());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCashAmount(int id, double newCashAmount) {
        if (atm != null && atm.getId() == id) {
            atm.setCashAmount(newCashAmount);
            System.out.println("Количество денег в банкомате обновлено: " + atm.getCashAmount());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateMaintenanceCost(int id, double newMaintenanceCost) {
        if (atm != null && atm.getId() == id) {
            atm.setMaintenanceCost(newMaintenanceCost);
            System.out.println("Стоимость обслуживания банкомата обновлена: " + atm.getMaintenanceCost());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void displayAtmInfo() {
        if (atm != null) {
            System.out.println(atm);
        } else {
            System.out.println("Банкомат не создан.");
        }
    }

    @Override
    public void deleteAtm(int id) {
        if (atm != null && atm.getId() == id) {
            atm = null;
            System.out.println("Банкомат с ID " + id + " удалён.");
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }
}


