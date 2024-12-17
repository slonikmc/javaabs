package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.CreditAccount;
import tech.reliab.course.ivanovda.bank.repository.CreditAccountRepository;
import tech.reliab.course.ivanovda.bank.service.CreditAccountService;

import java.util.List;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    private final CreditAccountRepository creditAccountRepository;

    @Autowired
    public CreditAccountServiceImpl(CreditAccountRepository creditAccountRepository) {
        this.creditAccountRepository = creditAccountRepository;
    }

    @Override
    public void createCreditAccount(CreditAccount creditAccount) {
        creditAccountRepository.save(creditAccount);
        System.out.println("Кредитный аккаунт создан: " + creditAccount);
    }

    @Override
    public void updateCreditAccount(int id, CreditAccount updatedCreditAccount) {
        if (creditAccountRepository.existsById(id)) {
            CreditAccount creditAccount = creditAccountRepository.findById(id).get();
            creditAccount.setStartDate(updatedCreditAccount.getStartDate());
            creditAccount.setCreditMonths(updatedCreditAccount.getCreditMonths());
            creditAccount.setCreditAmount(updatedCreditAccount.getCreditAmount());
            creditAccount.setInterestRate(updatedCreditAccount.getInterestRate());
            creditAccount.setEmployee(updatedCreditAccount.getEmployee());
            creditAccount.setPaymentAccount(updatedCreditAccount.getPaymentAccount());
            creditAccountRepository.save(creditAccount);
            System.out.println("Данные кредитного аккаунта обновлены: " + creditAccount);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountRepository.findAll();
    }

    @Override
    public CreditAccount getCreditAccountById(int id) {
        return creditAccountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCreditAccount(int id) {
        if (creditAccountRepository.existsById(id)) {
            creditAccountRepository.deleteById(id);
            System.out.println("Кредитный аккаунт с ID " + id + " удалён.");
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }
}
