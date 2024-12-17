package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.CreditAccount;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditAccountControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetCreditAccount() {
        CreditAccount creditAccount = new CreditAccount();
        ResponseEntity<CreditAccount> createResponse = restTemplate.postForEntity("/creditaccount", creditAccount, CreditAccount.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        CreditAccount createdCreditAccount = createResponse.getBody();
        assertThat(createdCreditAccount).isNotNull();
        assertThat(createdCreditAccount.getCreditAmount()).isEqualTo(creditAccount.getCreditAmount());

        ResponseEntity<CreditAccount> getResponse = restTemplate.getForEntity("/creditaccount/" + createdCreditAccount.getId(), CreditAccount.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        CreditAccount fetchedCreditAccount = getResponse.getBody();
        assertThat(fetchedCreditAccount).isNotNull();
        assertThat(fetchedCreditAccount.getCreditAmount()).isEqualTo(creditAccount.getCreditAmount());
    }

    @Test
    public void testGetAllCreditAccounts() {
        ResponseEntity<List> response = restTemplate.getForEntity("/creditaccount", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testDeleteCreditAccount() {
        CreditAccount creditAccount = new CreditAccount();
        ResponseEntity<CreditAccount> createResponse = restTemplate.postForEntity("/creditaccount", creditAccount, CreditAccount.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        CreditAccount createdCreditAccount = createResponse.getBody();
        restTemplate.delete("/creditaccount/" + createdCreditAccount.getId());

        ResponseEntity<CreditAccount> getResponse = restTemplate.getForEntity("/creditaccount/" + createdCreditAccount.getId(), CreditAccount.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
