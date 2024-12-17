package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
