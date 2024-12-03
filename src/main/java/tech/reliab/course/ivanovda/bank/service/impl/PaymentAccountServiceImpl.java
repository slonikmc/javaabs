package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.List;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    private final List<PaymentAccount> paymentAccounts = new ArrayList<>();

    @Override
    public void createPaymentAccount(int id, User user, Bank bank, double initialBalance) {
        PaymentAccount paymentAccount = new PaymentAccount(id, user, bank, initialBalance);
        paymentAccounts.add(paymentAccount);
        System.out.println("Платёжный аккаунт создан:\n" + paymentAccount);
    }

    @Override
    public void displayPaymentAccountInfo(int id) {
        PaymentAccount paymentAccount = findPaymentAccountById(id);
        if (paymentAccount != null) {
            System.out.println(paymentAccount);
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        PaymentAccount paymentAccount = findPaymentAccountById(id);
        if (paymentAccount != null) {
            paymentAccount.setBalance(newBalance);
            System.out.println("Баланс обновлён. Новый баланс: " + newBalance);
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }

    @Override
    public void deletePaymentAccount(int id) {
        PaymentAccount paymentAccount = findPaymentAccountById(id);
        if (paymentAccount != null) {
            paymentAccounts.remove(paymentAccount);
            System.out.println("Платёжный аккаунт с ID " + id + " удалён.");
        } else {
            System.out.println("Платёжный аккаунт с ID " + id + " не найден.");
        }
    }

    // Вспомогательный метод для поиска платёжного аккаунта по ID
    private PaymentAccount findPaymentAccountById(int id) {
        return paymentAccounts.stream()
                .filter(account -> account.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
