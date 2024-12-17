package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Integer> {
}
