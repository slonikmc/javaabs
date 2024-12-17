package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;

public interface AtmRepository extends JpaRepository<BankAtm, Integer> {
}
