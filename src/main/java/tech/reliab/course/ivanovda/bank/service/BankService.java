package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAllBanks();  // Получить все банки

    Bank getBankById(int id);  // Получить банк по ID

    Bank createBank(Bank bank);  // Создать новый банк

    Bank updateBank(int id, Bank bank);  // Обновить информацию о банке

    boolean deleteBank(int id);  // Удалить банк
}
