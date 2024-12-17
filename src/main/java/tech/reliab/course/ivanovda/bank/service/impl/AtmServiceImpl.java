package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;
import tech.reliab.course.ivanovda.bank.repository.AtmRepository;
import tech.reliab.course.ivanovda.bank.service.AtmService;

import java.util.List;

@Service
public class AtmServiceImpl implements AtmService {

    private final AtmRepository atmRepository;

    @Autowired
    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public void createAtm(int id, String name, String address, String status, Bank bank, boolean locatedInOffice,
                          String servicingEmployee, boolean canDispenseCash, boolean canAcceptDeposits,
                          double cashAmount, double maintenanceCost) {
        BankAtm atm = new BankAtm(id, name, address, status, bank, locatedInOffice, servicingEmployee,
                canDispenseCash, canAcceptDeposits, cashAmount, maintenanceCost);
        atmRepository.save(atm);
        System.out.println("Банкомат создан: " + atm);
    }

    @Override
    public void updateStatus(int id, String newStatus) {
        BankAtm atm = atmRepository.findById(id).orElse(null);
        if (atm != null) {
            atm.setStatus(newStatus);
            atmRepository.save(atm);
            System.out.println("Статус банкомата обновлен: " + atm.getStatus());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCashAmount(int id, double newCashAmount) {
        BankAtm atm = atmRepository.findById(id).orElse(null);
        if (atm != null) {
            atm.setCashAmount(newCashAmount);
            atmRepository.save(atm);
            System.out.println("Количество денег в банкомате обновлено: " + atm.getCashAmount());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateMaintenanceCost(int id, double newMaintenanceCost) {
        BankAtm atm = atmRepository.findById(id).orElse(null);
        if (atm != null) {
            atm.setMaintenanceCost(newMaintenanceCost);
            atmRepository.save(atm);
            System.out.println("Стоимость обслуживания банкомата обновлена: " + atm.getMaintenanceCost());
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public void displayAtmInfo() {
        List<BankAtm> atmList = atmRepository.findAll();
        if (atmList.isEmpty()) {
            System.out.println("Банкоматы отсутствуют.");
        } else {
            System.out.println("Список банкоматов:");
            atmList.forEach(System.out::println);
        }
    }

    @Override
    public void deleteAtm(int id) {
        if (atmRepository.existsById(id)) {
            atmRepository.deleteById(id);
            System.out.println("Банкомат с ID " + id + " удалён.");
        } else {
            System.out.println("Банкомат с ID " + id + " не найден.");
        }
    }

    @Override
    public List<BankAtm> getAllAtms() {
        return atmRepository.findAll();
    }

    @Override
    public BankAtm getAtmById(int id) {
        return atmRepository.findById(id).orElse(null);
    }

}
