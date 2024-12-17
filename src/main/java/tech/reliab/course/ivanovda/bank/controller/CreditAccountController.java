package tech.reliab.course.ivanovda.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.ivanovda.bank.entity.CreditAccount;
import tech.reliab.course.ivanovda.bank.service.CreditAccountService;

import java.util.List;

@RestController
@RequestMapping("/api/credit-accounts")
public class CreditAccountController {

    private final CreditAccountService creditAccountService;

    @Autowired
    public CreditAccountController(CreditAccountService creditAccountService) {
        this.creditAccountService = creditAccountService;
    }

    // Получить все кредитные аккаунты
    @GetMapping
    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountService.getAllCreditAccounts();
    }

    // Получить кредитный аккаунт по ID
    @GetMapping("/{id}")
    public ResponseEntity<CreditAccount> getCreditAccountById(@PathVariable int id) {
        CreditAccount creditAccount = creditAccountService.getCreditAccountById(id);
        return creditAccount != null ? ResponseEntity.ok(creditAccount)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Создать кредитный аккаунт
    @PostMapping
    public ResponseEntity<CreditAccount> createCreditAccount(@RequestBody CreditAccount creditAccount) {
        creditAccountService.createCreditAccount(creditAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(creditAccount);
    }

    // Обновить кредитный аккаунт
    @PutMapping("/{id}")
    public ResponseEntity<CreditAccount> updateCreditAccount(@PathVariable int id, @RequestBody CreditAccount updatedCreditAccount) {
        CreditAccount existingCreditAccount = creditAccountService.getCreditAccountById(id);
        if (existingCreditAccount != null) {
            creditAccountService.updateCreditAccount(id, updatedCreditAccount);
            return ResponseEntity.ok(updatedCreditAccount);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Удалить кредитный аккаунт
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditAccount(@PathVariable int id) {
        if (creditAccountService.getCreditAccountById(id) != null) {
            creditAccountService.deleteCreditAccount(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
