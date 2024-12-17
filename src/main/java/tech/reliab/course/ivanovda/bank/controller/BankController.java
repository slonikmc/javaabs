package tech.reliab.course.ivanovda.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.ivanovda.bank.entity.Bank;
import tech.reliab.course.ivanovda.bank.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    // Получить все банки
    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> banks = bankService.getAllBanks();
        if (banks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // Возвращаем 204, если нет банков
        }
        return ResponseEntity.ok(banks);
    }

    // Получить банк по ID
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable int id) {
        Bank bank = bankService.getBankById(id);
        if (bank == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(bank);
    }

    // Создать новый банк
    @PostMapping
    public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
        Bank createdBank = bankService.createBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBank);  // Возвращаем созданный банк с кодом 201
    }

    // Обновить информацию о банке
    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable int id, @RequestBody Bank bank) {
        Bank updatedBank = bankService.updateBank(id, bank);
        if (updatedBank == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedBank);
    }

    // Удалить банк
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable int id) {
        boolean isDeleted = bankService.deleteBank(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
