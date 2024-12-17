package tech.reliab.course.ivanivda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.BankOffice;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BankOfficeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateBankOffice() {
        BankOffice newOffice = new BankOffice();
        newOffice.setName("Test Office");

        ResponseEntity<BankOffice> response = restTemplate.postForEntity("/bank-offices", newOffice, BankOffice.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Office");
    }

    @Test
    void testGetAllBankOffices() {
        ResponseEntity<BankOffice[]> response = restTemplate.getForEntity("/bank-offices", BankOffice[].class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void testGetBankOfficeById() {
        BankOffice newOffice = new BankOffice();
        newOffice.setName("Test Office");
        BankOffice createdOffice = restTemplate.postForObject("/bank-offices", newOffice, BankOffice.class);

        ResponseEntity<BankOffice> response = restTemplate.getForEntity("/bank-offices/" + createdOffice.getId(), BankOffice.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Office");
    }

    @Test
    void testDeleteBankOffice() {
        BankOffice newOffice = new BankOffice();
        newOffice.setName("Office to Delete");
        BankOffice createdOffice = restTemplate.postForObject("/bank-offices", newOffice, BankOffice.class);

        restTemplate.delete("/bank-offices/" + createdOffice.getId());

        ResponseEntity<BankOffice> response = restTemplate.getForEntity("/bank-offices/" + createdOffice.getId(), BankOffice.class);
        assertThat(response.getStatusCode().is4xxClientError()).isTrue(); // BankOffice not found
    }
}
