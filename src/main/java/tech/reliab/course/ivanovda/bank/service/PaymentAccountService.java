package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.entity.User;

import java.util.List;

public interface PaymentAccountService {

    /**
     * Создает новый платежный счет для указанного пользователя в заданном банке с начальным балансом.
    */
    void createPaymentAccount(PaymentAccount paymentAccount);

    PaymentAccount getPaymentAccountById(int id);

    List<PaymentAccount> getAllPaymentAccounts();

    void updateBalance(int id, double newBalance);

    /**
     * Удаляет платежный счет с заданным идентификатором.
     *
     * @param id идентификатор платежного счета
     */
    void deletePaymentAccount(int id);
}
