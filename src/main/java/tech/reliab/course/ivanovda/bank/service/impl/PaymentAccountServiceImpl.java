package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;
import tech.reliab.course.ivanovda.bank.repository.PaymentAccountRepository;
import tech.reliab.course.ivanovda.bank.service.PaymentAccountService;

import java.util.List;

@Service
public class PaymentAccountServiceImpl implements PaymentAccountService {

    private final PaymentAccountRepository paymentAccountRepository;

    @Autowired
    public PaymentAccountServiceImpl(PaymentAccountRepository paymentAccountRepository) {
        this.paymentAccountRepository = paymentAccountRepository;
    }

    @Override
    public void createPaymentAccount(PaymentAccount paymentAccount) {
        paymentAccountRepository.save(paymentAccount);
        System.out.println("Платежный счет создан: " + paymentAccount);
    }

    @Override
    public PaymentAccount getPaymentAccountById(int id) {
        return paymentAccountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Счет с ID " + id + " не найден."));
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }

    @Override
    public void updateBalance(int id, double newBalance) {
        PaymentAccount paymentAccount = getPaymentAccountById(id);
        paymentAccount.setBalance(newBalance);
        paymentAccountRepository.save(paymentAccount);
        System.out.println("Баланс обновлен: " + paymentAccount);
    }

    @Override
    public void deletePaymentAccount(int id) {
        if (paymentAccountRepository.existsById(id)) {
            paymentAccountRepository.deleteById(id);
            System.out.println("Счет с ID " + id + " удален.");
        } else {
            System.out.println("Счет с ID " + id + " не найден.");
        }
    }
}
