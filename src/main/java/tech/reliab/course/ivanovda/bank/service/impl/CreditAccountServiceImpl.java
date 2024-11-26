package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.*;
import tech.reliab.course.ivanovda.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {
    private CreditAccount creditAccount;

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

        PaymentAccount paymentAccount = new PaymentAccount(1, user, bank, 0);

        // Создаём кредитный аккаунт
        creditAccount = new CreditAccount(id, user, bank, issueDate, 12, creditLimit, interestRate, employee, paymentAccount);

        System.out.println("Кредитный аккаунт создан:\n" + creditAccount);
    }

    @Override
    public void displayCreditAccountInfo(int id) {
        if (creditAccount != null && creditAccount.getId() == id) {
            System.out.println(creditAccount);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCreditLimit(int id, double newCreditLimit) {
        if (creditAccount != null && creditAccount.getId() == id) {
            creditAccount.setCreditAmount(newCreditLimit);
            System.out.println("Кредитный лимит обновлён. Новый лимит: " + newCreditLimit);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateInterestRate(int id, double newInterestRate) {
        if (creditAccount != null && creditAccount.getId() == id) {
            creditAccount.setInterestRate(newInterestRate);
            System.out.println("Процентная ставка обновлена. Новая ставка: " + newInterestRate);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateCurrentDebt(int id, double newDebt) {
        if (creditAccount != null && creditAccount.getId() == id) {
            creditAccount.getPaymentAccount().setBalance(newDebt); // Обновляем задолженность через платёжный аккаунт
            System.out.println("Текущая задолженность обновлена. Новая задолженность: " + newDebt);
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteCreditAccount(int id) {
        if (creditAccount != null && creditAccount.getId() == id) {
            creditAccount = null;
            System.out.println("Кредитный аккаунт с ID " + id + " удалён.");
        } else {
            System.out.println("Кредитный аккаунт с ID " + id + " не найден.");
        }
    }
}
