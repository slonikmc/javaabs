package tech.reliab.course.ivanovda.bank.entity;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int numberOfOffices;
    private int numberOfATMs;
    private int numberOfEmployees;
    private int numberOfClients;
    private int rating;
    private double totalCash;
    private double interestRate;

    public Bank(String name) {
        this.name = name;
        this.numberOfOffices = 0;
        this.numberOfATMs = 0;
        this.numberOfEmployees = 0;
        this.numberOfClients = 0;
        this.rating = generateRating();
        this.totalCash = generateTotalCash();
        this.interestRate = generateInterestRate();
    }

    private int generateRating() {
        return new Random().nextInt(101);
    }

    private double generateTotalCash() {
        return new Random().nextDouble() * 1000000;
    }

    private double generateInterestRate() {
        double baseRate = new Random().nextDouble() * 20;
        if (rating > 0) {
            baseRate *= (100 - rating) / 100.0;
        }
        return Math.max(0, Math.min(baseRate, 20));
    }

    public void setRating(int rating) {
        if (rating < 0 || rating > 100) {
            throw new IllegalArgumentException("Рейтинг должен быть от 0 до 100.");
        }
        this.rating = rating;
        this.interestRate = generateInterestRate();
    }

    public void setTotalCash(double totalCash) {
        if (totalCash < 0 || totalCash > 1000000) {
            throw new IllegalArgumentException("Сумма денег должна быть от 0 до 1000000.");
        }
        this.totalCash = totalCash;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate < 0 || interestRate > 20) {
            throw new IllegalArgumentException("Процентная ставка должна быть от 0 до 20.");
        }
        this.interestRate = interestRate;
    }

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
                ", totalCash=" + totalCash +
                ", interestRate=" + interestRate +
                '}';
    }
}
