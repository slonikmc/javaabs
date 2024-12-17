package tech.reliab.course.ivanovda.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.ivanovda.bank.entity.BankOffice;
import tech.reliab.course.ivanovda.bank.service.BankOfficeService;

import java.util.List;

@RestController
@RequestMapping("/api/bank-offices")
public class BankOfficeController {

    private final BankOfficeService bankOfficeService;

    @Autowired
    public BankOfficeController(BankOfficeService bankOfficeService) {
        this.bankOfficeService = bankOfficeService;
    }

    // Получить все офисы банка
    @GetMapping
    public ResponseEntity<List<BankOffice>> getAllBankOffices() {
        List<BankOffice> bankOffices = bankOfficeService.getAllBankOffices();
        if (bankOffices.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bankOffices);
    }

    // Получить офис банка по ID
    @GetMapping("/{id}")
    public ResponseEntity<BankOffice> getBankOfficeById(@PathVariable int id) {
        BankOffice bankOffice = bankOfficeService.getBankOfficeById(id);
        if (bankOffice != null) {
            return ResponseEntity.ok(bankOffice);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Создать новый офис банка
    @PostMapping
    public ResponseEntity<Void> createBankOffice(@RequestParam String name, @RequestParam String address) {
        bankOfficeService.createBankOffice(name, address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Обновить информацию об офисе банка
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBankOfficeDetails(
            @PathVariable int id,
            @RequestParam String newName,
            @RequestParam String newAddress,
            @RequestParam String newStatus,
            @RequestParam boolean newCanPlaceAtm,
            @RequestParam int newNumberOfAtms,
            @RequestParam boolean newCanIssueLoans,
            @RequestParam boolean newCanDispenseCash,
            @RequestParam boolean newCanAcceptDeposits,
            @RequestParam double newCashAmount,
            @RequestParam double newRentCost
    ) {
        bankOfficeService.updateBankOfficeDetails(id, newName, newAddress, newStatus, newCanPlaceAtm,
                newNumberOfAtms, newCanIssueLoans, newCanDispenseCash, newCanAcceptDeposits, newCashAmount, newRentCost);
        return ResponseEntity.ok().build();
    }

    // Удалить офис банка
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankOffice(@PathVariable int id) {
        bankOfficeService.deleteBankOffice(id);
        return ResponseEntity.noContent().build();
    }
}
