package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.BankAtm;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtmControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetAtm() {
        BankAtm atm = new BankAtm();
        ResponseEntity<BankAtm> createResponse = restTemplate.postForEntity("/atm", atm, BankAtm.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        BankAtm createdAtm = createResponse.getBody();
        assertThat(createdAtm).isNotNull();
        assertThat(createdAtm.getName()).isEqualTo(atm.getName());

        ResponseEntity<BankAtm> getResponse = restTemplate.getForEntity("/atm/" + createdAtm.getId(), BankAtm.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        BankAtm fetchedAtm = getResponse.getBody();
        assertThat(fetchedAtm).isNotNull();
        assertThat(fetchedAtm.getName()).isEqualTo(atm.getName());
    }

    @Test
    public void testGetAllAtms() {
        ResponseEntity<List> response = restTemplate.getForEntity("/atm", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testDeleteAtm() {
        BankAtm atm = new BankAtm();
        ResponseEntity<BankAtm> createResponse = restTemplate.postForEntity("/atm", atm, BankAtm.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        BankAtm createdAtm = createResponse.getBody();
        restTemplate.delete("/atm/" + createdAtm.getId());

        ResponseEntity<BankAtm> getResponse = restTemplate.getForEntity("/atm/" + createdAtm.getId(), BankAtm.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
