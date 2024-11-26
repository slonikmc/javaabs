package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;
import java.util.List;

public interface AtmService {

    /**
     * Создает новый банкомат.
     *
     * @param id                 идентификатор банкомата
     * @param name               название банкомата
     * @param address            адрес установки банкомата
     * @param status             статус банкомата (например, "Работает", "Не работает")
     * @param bank               банк, которому принадлежит банкомат
     * @param locatedInOffice    расположение банкомата (в офисе или вне его)
     * @param servicingEmployee  сотрудник, обслуживающий банкомат
     * @param canDispenseCash    возможность выдачи наличных
     * @param canAcceptDeposits  возможность принятия депозитов
     * @param cashAmount         сумма наличных в банкомате
     * @param maintenanceCost    стоимость обслуживания банкомата
     */
    void createAtm(int id, String name, String address, String status, Bank bank,
                   boolean locatedInOffice, String servicingEmployee,
                   boolean canDispenseCash, boolean canAcceptDeposits,
                   double cashAmount, double maintenanceCost);

    /**
     * Обновляет статус банкомата.
     *
     * @param id          идентификатор банкомата
     * @param newStatus   новый статус банкомата
     */
    void updateStatus(int id, String newStatus);

    /**
     * Обновляет сумму наличных в банкомате.
     *
     * @param id             идентификатор банкомата
     * @param newCashAmount  новая сумма наличных в банкомате
     */
    void updateCashAmount(int id, double newCashAmount);

    /**
     * Обновляет стоимость обслуживания банкомата.
     *
     * @param id                 идентификатор банкомата
     * @param newMaintenanceCost новая стоимость обслуживания банкомата
     */
    void updateMaintenanceCost(int id, double newMaintenanceCost);

    /**
     * Выводит информацию о банкомате.
     */
    void displayAtmInfo();

    /**
     * Удаляет банкомат по его идентификатору.
     *
     * @param id идентификатор банкомата
     */
    void deleteAtm(int id);
}




