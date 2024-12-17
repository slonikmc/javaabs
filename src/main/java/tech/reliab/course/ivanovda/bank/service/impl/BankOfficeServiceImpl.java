package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.BankOffice;
import tech.reliab.course.ivanovda.bank.repository.BankOfficeRepository;
import tech.reliab.course.ivanovda.bank.service.BankOfficeService;

import java.util.List;

@Service
public class BankOfficeServiceImpl implements BankOfficeService {

    private final BankOfficeRepository bankOfficeRepository;

    @Autowired
    public BankOfficeServiceImpl(BankOfficeRepository bankOfficeRepository) {
        this.bankOfficeRepository = bankOfficeRepository;
    }

    @Override
    public void createBankOffice(String name, String address) {
        BankOffice bankOffice = new BankOffice();
        bankOffice.setName(name);
        bankOffice.setAddress(address);
        bankOfficeRepository.save(bankOffice);
        System.out.println("Офис банка создан: " + bankOffice);
    }

    @Override
    public void updateBankOfficeDetails(int id, String newName, String newAddress, String newStatus, boolean newCanPlaceAtm,
                                        int newNumberOfAtms, boolean newCanIssueLoans, boolean newCanDispenseCash,
                                        boolean newCanAcceptDeposits, double newCashAmount, double newRentCost) {
        BankOffice bankOffice = bankOfficeRepository.findById(id).orElse(null);
        if (bankOffice != null) {
            bankOffice.setName(newName);
            bankOffice.setAddress(newAddress);
            bankOffice.setStatus(newStatus);
            bankOffice.setCanPlaceAtm(newCanPlaceAtm);
            bankOffice.setNumberOfAtms(newNumberOfAtms);
            bankOffice.setCanIssueLoans(newCanIssueLoans);
            bankOffice.setCanDispenseCash(newCanDispenseCash);
            bankOffice.setCanAcceptDeposits(newCanAcceptDeposits);
            bankOffice.setCashAmount(newCashAmount);
            bankOffice.setRentCost(newRentCost);
            bankOfficeRepository.save(bankOffice);
            System.out.println("Данные офиса банка обновлены: " + bankOffice);
        } else {
            System.out.println("Офис банка с ID " + id + " не найден.");
        }
    }

    @Override
    public void displayBankOfficeInfo() {
        List<BankOffice> bankOffices = bankOfficeRepository.findAll();
        if (bankOffices.isEmpty()) {
            System.out.println("Офисы банка отсутствуют.");
        } else {
            System.out.println("Список офисов банка:");
            bankOffices.forEach(System.out::println);
        }
    }

    @Override
    public void deleteBankOffice(int id) {
        if (bankOfficeRepository.existsById(id)) {
            bankOfficeRepository.deleteById(id);
            System.out.println("Офис банка с ID " + id + " удалён.");
        } else {
            System.out.println("Офис банка с ID " + id + " не найден.");
        }
    }

    @Override
    public BankOffice getBankOfficeById(int id) {
        return bankOfficeRepository.findById(id).orElse(null);
    }

    @Override
    public List<BankOffice> getAllBankOffices() {
        return bankOfficeRepository.findAll();
    }
}
