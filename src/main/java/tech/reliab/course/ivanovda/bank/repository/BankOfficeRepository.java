package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.BankOffice;

public interface BankOfficeRepository extends JpaRepository<BankOffice, Integer> {
}
