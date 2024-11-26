package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    private PaymentAccount paymentAccount;

    @Override
    public void createPaymentAccount(int id, User user, Bank bank, double initialBalance) {
        paymentAccount = new PaymentAccount(id, user, bank, initialBalance);
        System.out.println("Платёжный аккаунт создан:\n" + paymentAccount);
    }

    @Override
    public void displayPaymentAccountInfo(int id) {
        if (paymentAccount != null && paymentAccount.getId() == id) {
            System.out.println(paymentAccount);
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        if (paymentAccount != null && paymentAccount.getId() == id) {
            paymentAccount.setBalance(newBalance);
            System.out.println("Баланс обновлён. Новый баланс: " + newBalance);
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void deletePaymentAccount(int id) {
        if (paymentAccount != null && paymentAccount.getId() == id) {
            paymentAccount = null;
            System.out.println("Платёжный аккаунт с ID " + id + " удалён.");
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }
}
