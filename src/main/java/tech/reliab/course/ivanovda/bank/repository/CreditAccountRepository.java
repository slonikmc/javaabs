package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.CreditAccount;

public interface CreditAccountRepository extends JpaRepository<CreditAccount, Integer> {
}
