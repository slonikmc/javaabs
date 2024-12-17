package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.repository.BankRepository;
import tech.reliab.course.ivanovda.bank.service.BankService;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getBankById(int id) {
        Optional<Bank> bank = bankRepository.findById(id);
        return bank.orElse(null);
    }

    @Override
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(int id, Bank bank) {
        if (bankRepository.existsById(id)) {
            bank.setId(id);
            Bank save = bankRepository.save(bank);
            return save;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBank(int id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
