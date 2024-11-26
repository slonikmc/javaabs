package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.BankOffice;

public interface BankOfficeService {

    /**
     * Создает новый офис банка.
     *
     * @param id                идентификатор офиса
     * @param name              название офиса
     * @param address           адрес офиса
     * @param status            статус офиса (например, "Открыт", "Закрыт")
     * @param canPlaceAtm       возможность размещения банкоматов в офисе
     * @param numberOfAtms      количество банкоматов в офисе
     * @param canIssueLoans     возможность выдачи кредитов в офисе
     * @param canDispenseCash   возможность выдачи наличных в офисе
     * @param canAcceptDeposits возможность принятия депозитов в офисе
     * @param cashAmount        сумма наличных, доступная в офисе
     * @param rentCost          стоимость аренды офиса
     */
    void createBankOffice(int id, String name, String address, String status, boolean canPlaceAtm, int numberOfAtms,
                          boolean canIssueLoans, boolean canDispenseCash, boolean canAcceptDeposits, double cashAmount, double rentCost);

    /**
     * Выводит информацию о банке.
     *
     * @param id идентификатор офиса банка
     */
    void displayBankOfficeInfo(int id);

    /**
     * Обновляет статус офиса.
     *
     * @param id          идентификатор офиса
     * @param status      новый статус офиса (например, "Открыт", "Закрыт")
     */
    void updateStatus(int id, String status);

    /**
     * Обновляет количество банкоматов в офисе.
     *
     * @param id                идентификатор офиса
     * @param numberOfAtms      новое количество банкоматов в офисе
     */
    void updateNumberOfAtms(int id, int numberOfAtms);

    /**
     * Обновляет стоимость аренды офиса.
     *
     * @param id            идентификатор офиса
     * @param rentCost      новая стоимость аренды офиса
     */
    void updateRentCost(int id, double rentCost);

    /**
     * Удаляет офис банка по его идентификатору.
     *
     * @param id идентификатор офиса
     */
    void deleteBankOffice(int id);
}
