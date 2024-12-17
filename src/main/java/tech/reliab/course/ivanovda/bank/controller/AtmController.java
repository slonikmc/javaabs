package tech.reliab.course.ivanovda.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;
import tech.reliab.course.ivanovda.bank.service.AtmService;

import java.util.List;

@RestController
@RequestMapping("/api/atms")
public class AtmController {

    private final AtmService atmService;

    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    // Получить список всех банкоматов
    @GetMapping
    public ResponseEntity<List<BankAtm>> getAllAtms() {
        List<BankAtm> atmList = atmService.getAllAtms();
        if (atmList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(atmList);
    }

    // Создать новый банкомат
    @PostMapping
    public ResponseEntity<String> createAtm(@RequestBody BankAtm atm) {
        atmService.createAtm(atm.getId(), atm.getName(), atm.getAddress(), atm.getStatus(),
                atm.getBank(), atm.isLocatedInOffice(), atm.getServicingEmployee(),
                atm.isCanDispenseCash(), atm.isCanAcceptDeposits(),
                atm.getCashAmount(), atm.getMaintenanceCost());
        return ResponseEntity.status(HttpStatus.CREATED).body("Банкомат создан.");
    }

    // Получить информацию о банкомате по ID
    @GetMapping("/{id}")
    public ResponseEntity<BankAtm> getAtmById(@PathVariable int id) {
        BankAtm atm = atmService.getAtmById(id);
        if (atm == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(atm);
    }

    // Обновить статус банкомата
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestParam String newStatus) {
        atmService.updateStatus(id, newStatus);
        return ResponseEntity.ok("Статус банкомата обновлен.");
    }

    // Обновить количество наличных в банкомате
    @PutMapping("/{id}/cash")
    public ResponseEntity<String> updateCashAmount(@PathVariable int id, @RequestParam double newCashAmount) {
        atmService.updateCashAmount(id, newCashAmount);
        return ResponseEntity.ok("Количество наличных в банкомате обновлено.");
    }

    // Обновить стоимость обслуживания банкомата
    @PutMapping("/{id}/maintenance")
    public ResponseEntity<String> updateMaintenanceCost(@PathVariable int id, @RequestParam double newMaintenanceCost) {
        atmService.updateMaintenanceCost(id, newMaintenanceCost);
        return ResponseEntity.ok("Стоимость обслуживания банкомата обновлена.");
    }

    // Удалить банкомат по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAtm(@PathVariable int id) {
        atmService.deleteAtm(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
