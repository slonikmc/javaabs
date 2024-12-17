package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.Bank;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BankControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateBank() {
        Bank newBank = new Bank("Test Bank");

        ResponseEntity<Bank> response = restTemplate.postForEntity("/banks", newBank, Bank.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Bank");
    }

    @Test
    void testGetAllBanks() {
        ResponseEntity<Bank[]> response = restTemplate.getForEntity("/banks", Bank[].class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void testGetBankById() {
        Bank newBank = new Bank("Test Bank");
        Bank createdBank = restTemplate.postForObject("/banks", newBank, Bank.class);

        ResponseEntity<Bank> response = restTemplate.getForEntity("/banks/" + createdBank.getId(), Bank.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Bank");
    }

    @Test
    void testDeleteBank() {
        Bank newBank = new Bank("Bank to Delete");
        Bank createdBank = restTemplate.postForObject("/banks", newBank, Bank.class);

        restTemplate.delete("/banks/" + createdBank.getId());

        ResponseEntity<Bank> response = restTemplate.getForEntity("/banks/" + createdBank.getId(), Bank.class);
        assertThat(response.getStatusCode().is4xxClientError()).isTrue(); // Bank not found
    }
}
