package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {

    /**
     * Создает новый офис банка.
     * @param name              название офиса
     * @param address           адрес офиса
     */
    void createBankOffice(String name, String address);

    /**
     * Выводит информацию о банке.
     */
    void displayBankOfficeInfo();

    /**
     * Обновляет детали офиса.
     *
     * @param id          идентификатор офиса
     */
    void updateBankOfficeDetails(int id, String newName, String newAddress, String newStatus, boolean newCanPlaceAtm,
                                              int newNumberOfAtms, boolean newCanIssueLoans, boolean newCanDispenseCash,
                                              boolean newCanAcceptDeposits, double newCashAmount, double newRentCost);

    /**
     * Удаляет офис банка по его идентификатору.
     *
     * @param id идентификатор офиса
     */
    void deleteBankOffice(int id);

    BankOffice getBankOfficeById(int id);

    List<BankOffice> getAllBankOffices();
}
