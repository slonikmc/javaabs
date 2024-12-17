package tech.reliab.course.ivanovda.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.service.PaymentAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/payment-accounts")
public class PaymentAccountController {

    private final PaymentAccountService paymentAccountService;

    @Autowired
    public PaymentAccountController(PaymentAccountService paymentAccountService) {
        this.paymentAccountService = paymentAccountService;
    }

    // Получить все счета
    @GetMapping
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountService.getAllPaymentAccounts();
    }

    // Получить счёт по ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentAccount> getPaymentAccountById(@PathVariable int id) {
        try {
            PaymentAccount paymentAccount = paymentAccountService.getPaymentAccountById(id);
            return ResponseEntity.ok(paymentAccount);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Создать платёжный счёт
    @PostMapping
    public ResponseEntity<PaymentAccount> createPaymentAccount(@RequestBody PaymentAccount paymentAccount) {
        paymentAccountService.createPaymentAccount(paymentAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentAccount);
    }

    // Обновить баланс счёта
    @PutMapping("/{id}/balance")
    public ResponseEntity<Void> updateBalance(@PathVariable int id, @RequestParam double newBalance) {
        try {
            paymentAccountService.updateBalance(id, newBalance);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Удалить счёт
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentAccount(@PathVariable int id) {
        try {
            paymentAccountService.deletePaymentAccount(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
