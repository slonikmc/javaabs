package tech.reliab.course.ivanovda.bank;

import tech.reliab.course.ivanovda.bank.entity.*;
import tech.reliab.course.ivanovda.bank.service.*;
import tech.reliab.course.ivanovda.bank.service.impl.*;

import java.time.LocalDate;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Создаем банк
        Bank bank = new Bank(1, "Ы-банк");
        System.out.println("Создан банк: " + bank);

        //Создаем офис банка
        BankOffice bankOffice = new BankOffice(1, "Main Office", "Борисовка", "Работает", true, 5,
                true, true, true, 500000, 20000);
        System.out.println("Создан офис банка: " + bankOffice);

        //Создаем банкомат
        BankAtm bankAtm = new BankAtm(1, "единственный банкомат", "Main St, 101", "Работает", bank, true, "Дмитрий Иванов", true, true, 50000, 500);
        System.out.println("Создан банкомат: " + bankAtm);

        //Создаем сотрудника
        Employee employee = new Employee(1, "Иван Дмитриев", LocalDate.of(2004, 3, 15), "Manager", bank,
                false, "Main Office", true, 15000);
        System.out.println("Создан сотрудник: " + employee);

        //Создаем клиента
        User user = new User(1, "Михаил Елизаров", LocalDate.of(1973, 1, 28), "Писатель");
        System.out.println("Создан пользователь: " + user);

        //Создаем платежный аккаунт
        PaymentAccount paymentAccount = new PaymentAccount(1, user, bank, 10000);
        System.out.println("Создан платежный аккаунт: " + paymentAccount);

        //Создаем кредитный аккаунт
        CreditAccount creditAccount = new CreditAccount(1, user, bank, LocalDate.of(2024, 11, 26), 12,
                5000.00, 7.5, employee, paymentAccount);
        System.out.println("Создан кредитный аккаунт: " + creditAccount);

        UserService user2 = new UserServiceImpl();
        user2.createUser(2, "Елизар Михаилов", LocalDate.of(1937, 1, 28), "Исполнитель");
        user2.updateUser(2, "Чаризард Михайлов", LocalDate.of(1987, 8, 15), "Покемон");
        user2.deleteUser(2);

    }
}

