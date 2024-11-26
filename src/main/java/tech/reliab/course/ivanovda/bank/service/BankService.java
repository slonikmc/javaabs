package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import java.util.List;

public interface BankService {

    /**
     * Создает новый банк с заданным идентификатором и именем.
     *
     * @param id    идентификатор банка
     * @param name  название банка
     * @return новый экземпляр банка
     */
    Bank createBank(int id, String name);

    /**
     * Возвращает информацию о текущем банке.
     *
     * @return объект банка
     */
    Bank getBank();

    /**
     * Обновляет имя банка.
     *
     * @param name новое имя банка
     */
    void updateBankName(String name);

    /**
     * Обновляет рейтинг банка.
     *
     * @param rating новый рейтинг банка
     */
    void updateBankRating(int rating);

    /**
     * Обновляет общую сумму наличных в банке.
     *
     * @param totalCash новая сумма наличных
     */
    void updateTotalCash(double totalCash);

    /**
     * Увеличивает количество офисов банка на 1.
     */
    void incrementOffices();

    /**
     * Увеличивает количество банкоматов банка на 1.
     */
    void incrementATMs();

    /**
     * Увеличивает количество сотрудников банка на 1.
     */
    void incrementEmployees();

    /**
     * Увеличивает количество клиентов банка на 1.
     */
    void incrementClients();

    /**
     * Выводит полную информацию о банке.
     */
    void displayBankInfo();
}
