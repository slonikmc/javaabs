package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.User;

import java.time.LocalDate;

public interface CreditAccountService {
    /**
     * Создает новый кредитный счет.
     *
     * @param id           идентификатор счета
     * @param bank         банк, выдавший кредит
     * @param user         пользователь
     * @param creditLimit  кредитный лимит
     * @param interestRate процентная ставка
     * @param issueDate    дата выдачи кредита
     * @param dueDate      дата окончания кредита
     * @param currentDebt  текущая задолженность
     */
    void createCreditAccount(int id, Bank bank, User user, double creditLimit, double interestRate, LocalDate issueDate, LocalDate dueDate, double currentDebt);

    /**
     * Выводит информацию о кредитном счете.
     *
     * @param id идентификатор счета
     */
    void displayCreditAccountInfo(int id);

    /**
     * Обновляет кредитный лимит.
     *
     * @param id             идентификатор счета
     * @param newCreditLimit новый кредитный лимит
     */
    void updateCreditLimit(int id, double newCreditLimit);

    /**
     * Обновляет процентную ставку.
     *
     * @param id              идентификатор счета
     * @param newInterestRate новая процентная ставка
     */
    void updateInterestRate(int id, double newInterestRate);

    /**
     * Обновляет текущую задолженность.
     *
     * @param id       идентификатор счета
     * @param newDebt  новое значение задолженности
     */
    void updateCurrentDebt(int id, double newDebt);

    /**
     * Удаляет кредитный счет.
     *
     * @param id идентификатор счета
     */
    void deleteCreditAccount(int id);
}
