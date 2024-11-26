package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.entity.User;

public interface PaymentAccountService {

    /**
     * Создает новый платежный счет для указанного пользователя в заданном банке с начальным балансом.
     *
     * @param id              идентификатор платежного счета
     * @param user            пользователь, которому принадлежит счет
     * @param bank            банк, в котором открыт счет
     * @param initialBalance  начальный баланс на счету
     */
    void createPaymentAccount(int id, User user, Bank bank, double initialBalance);

    /**
     * Выводит информацию о платежном счете с заданным идентификатором.
     *
     * @param id идентификатор платежного счета
     */
    void displayPaymentAccountInfo(int id);

    /**
     * Обновляет баланс платежного счета.
     *
     * @param id            идентификатор платежного счета
     * @param newBalance    новый баланс на счету
     */
    void updateBalance(int id, double newBalance);

    /**
     * Удаляет платежный счет с заданным идентификатором.
     *
     * @param id идентификатор платежного счета
     */
    void deletePaymentAccount(int id);
}
