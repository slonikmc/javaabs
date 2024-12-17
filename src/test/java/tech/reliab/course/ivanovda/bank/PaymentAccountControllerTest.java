package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.PaymentAccount;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentAccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetPaymentAccount() {
        PaymentAccount paymentAccount = new PaymentAccount();
        ResponseEntity<PaymentAccount> createResponse = restTemplate.postForEntity("/paymentaccount", paymentAccount, PaymentAccount.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        PaymentAccount createdPaymentAccount = createResponse.getBody();
        assertThat(createdPaymentAccount).isNotNull();
        assertThat(createdPaymentAccount.getBalance()).isEqualTo(paymentAccount.getBalance());

        ResponseEntity<PaymentAccount> getResponse = restTemplate.getForEntity("/paymentaccount/" + createdPaymentAccount.getId(), PaymentAccount.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        PaymentAccount fetchedPaymentAccount = getResponse.getBody();
        assertThat(fetchedPaymentAccount).isNotNull();
        assertThat(fetchedPaymentAccount.getBalance()).isEqualTo(paymentAccount.getBalance());
    }

    @Test
    public void testGetAllPaymentAccounts() {
        ResponseEntity<List> response = restTemplate.getForEntity("/paymentaccount", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testDeletePaymentAccount() {
        PaymentAccount paymentAccount = new PaymentAccount();
        ResponseEntity<PaymentAccount> createResponse = restTemplate.postForEntity("/paymentaccount", paymentAccount, PaymentAccount.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        PaymentAccount createdPaymentAccount = createResponse.getBody();
        restTemplate.delete("/paymentaccount/" + createdPaymentAccount.getId());

        ResponseEntity<PaymentAccount> getResponse = restTemplate.getForEntity("/paymentaccount/" + createdPaymentAccount.getId(), PaymentAccount.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
