package tech.reliab.course.ivanovda.bank.entity;

import java.util.Random;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    // id банка
    private int id;
    // имя банка
    private String name;
    // количество офисов
    private int numberOfOffices;
    // количество банкоматов
    private int numberOfATMs;
    // количество сотрудников
    private int numberOfEmployees;
    // количество клиентов
    private int numberOfClients;
    // рейтинг банка
    private int rating;
    // всего денег в банке
    private double totalCash;
    // процентная ставка
    private double interestRate;

    // Конструктор для создания объекта банка
    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
        this.numberOfOffices = 0;
        this.numberOfATMs = 0;
        this.numberOfEmployees = 0;
        this.numberOfClients = 0;
        this.rating = generateRating();
        this.totalCash = generateTotalCash();
        this.interestRate = generateInterestRate();
    }

    // Метод для генерации случайного рейтинга
    private int generateRating() {
        Random rand = new Random();
        return rand.nextInt(101); // рейтинг от 0 до 100
    }

    // Метод для генерации общей суммы денег
    private double generateTotalCash() {
        Random rand = new Random();
        return rand.nextDouble() * 1000000; // сумма до 1000000
    }

    // Метод для генерации процентной ставки
    private double generateInterestRate() {
        Random rand = new Random();
        double baseRate = rand.nextDouble() * 20; // базовая ставка до 20%
        if (rating > 0) {
            baseRate = baseRate * (100 - rating) / 100; // ставка уменьшается с увеличением рейтинга
        }
        return Math.min(baseRate, 20); // ограничение до 20%
    }

    public void setRating(int rating) {
        if (rating >= 0 && rating <= 100) {
            this.rating = rating;
            this.interestRate = generateInterestRate();
        } else {
            throw new IllegalArgumentException("от 0 до 100");
        }
    }

    public void setTotalCash(double totalCash) {
        if (totalCash >= 0 && totalCash <= 1000000) {
            this.totalCash = totalCash;
        } else {
            throw new IllegalArgumentException("от 0 до 1000000");
        }
    }

    public void setInterestRate(double interestRate) {
        if (interestRate >= 0 && interestRate <= 20) {
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("от 0 до 20 ставка");
        }
    }

    // Методы для увеличения количества офисов, банкоматов, сотрудников и клиентов
    public void addOffice() {
        numberOfOffices++;
    }

    public void addAtm() {
        numberOfATMs++;
    }

    public void addEmployee() {
        numberOfEmployees++;
    }

    public void addClient() {
        numberOfClients++;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfOffices=" + numberOfOffices +
                ", numberOfATMs=" + numberOfATMs +
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfClients=" + numberOfClients +
                ", rating=" + rating +
                ", totalFunds=" + totalCash +
                ", interestRate=" + interestRate +
                '}';
    }
}
