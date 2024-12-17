package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.CreditAccount;
import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.repository.CreditAccountRepository;

import java.time.LocalDate;
import java.util.List;

public interface CreditAccountService {
    /**
     * Создает новый кредитный счет.
     */
    void createCreditAccount(CreditAccount creditAccount);

    List<CreditAccount> getAllCreditAccounts();

    void updateCreditAccount(int id, CreditAccount updatedCreditAccount);

    CreditAccount getCreditAccountById(int id);
    /**
     * Удаляет кредитный счет.
     *
     * @param id идентификатор счета
     */
    void deleteCreditAccount(int id);
}
