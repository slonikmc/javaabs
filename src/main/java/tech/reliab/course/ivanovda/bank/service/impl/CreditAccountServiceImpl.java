package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.*;
import tech.reliab.course.ivanovda.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditAccountServiceImpl implements CreditAccountService {

    private final List<CreditAccount> creditAccounts = new ArrayList<>(); // Список кредитных аккаунтов

    @Override
    public void createCreditAccount(int id, Bank bank, User user, double creditLimit, double interestRate, LocalDate issueDate, LocalDate dueDate, double currentDebt) {

        Employee employee = new Employee(
                1,                               // id
                "Default Employee",              // fullName
                LocalDate.of(1990, 1, 1),        // dateOfBirth
                "Manager",                       // position
                bank,                            // bankName
                false,                           // worksRemotely
                "Central Office",                // bankOffice
                true,                            // canIssueLoans
                50000                            // salary
        );

        PaymentAccount paymentAccount = new PaymentAccount(1, user, bank, currentDebt);

        CreditAccount creditAccount = new CreditAccount(id, user, bank, issueDate, 12, creditLimit, interestRate, employee, paymentAccount);
        creditAccounts.add(creditAccount);
        System.out.println("Кредитный аккаунт создан:\n" + creditAccount);
    }

    @Override
    public void displayCreditAccountInfo(int id) {
        CreditAccount creditAccount = findCreditAccountById(id);
        if (creditAccount != null) {
            System.out.println(creditAccount);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCreditLimit(int id, double newCreditLimit) {
        CreditAccount creditAccount = findCreditAccountById(id);
        if (creditAccount != null) {
            creditAccount.setCreditAmount(newCreditLimit);
            System.out.println("Кредитный лимит обновлён. Новый лимит: " + newCreditLimit);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateInterestRate(int id, double newInterestRate) {
        CreditAccount creditAccount = findCreditAccountById(id);
        if (creditAccount != null) {
            creditAccount.setInterestRate(newInterestRate);
            System.out.println("Процентная ставка обновлена. Новая ставка: " + newInterestRate);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCurrentDebt(int id, double newDebt) {
        CreditAccount creditAccount = findCreditAccountById(id);
        if (creditAccount != null) {
            creditAccount.getPaymentAccount().setBalance(newDebt);
            System.out.println("Текущая задолженность обновлена. Новая задолженность: " + newDebt);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteCreditAccount(int id) {
        CreditAccount creditAccount = findCreditAccountById(id);
        if (creditAccount != null) {
            creditAccounts.remove(creditAccount);
            System.out.println("Кредитный аккаунт с ID " + id + " удалён.");
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    //Вспомогательный метод для поиска кредитного аккаунта по ID
    private CreditAccount findCreditAccountById(int id) {
        return creditAccounts.stream()
                .filter(account -> account.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
