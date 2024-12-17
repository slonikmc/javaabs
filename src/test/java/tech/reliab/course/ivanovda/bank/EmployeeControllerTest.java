package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.Employee;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateAndGetEmployee() {
        Employee employee = new Employee();
        ResponseEntity<Employee> createResponse = restTemplate.postForEntity("/employee", employee, Employee.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        Employee createdEmployee = createResponse.getBody();
        assertThat(createdEmployee).isNotNull();
        assertThat(createdEmployee.getFullName()).isEqualTo(employee.getFullName());

        ResponseEntity<Employee> getResponse = restTemplate.getForEntity("/employee/" + createdEmployee.getId(), Employee.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        Employee fetchedEmployee = getResponse.getBody();
        assertThat(fetchedEmployee).isNotNull();
        assertThat(fetchedEmployee.getFullName()).isEqualTo(employee.getFullName());
    }

    @Test
    public void testGetAllEmployees() {
        ResponseEntity<List> response = restTemplate.getForEntity("/employee", List.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee();
        ResponseEntity<Employee> createResponse = restTemplate.postForEntity("/employee", employee, Employee.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        Employee createdEmployee = createResponse.getBody();
        restTemplate.delete("/employee/" + createdEmployee.getId());

        ResponseEntity<Employee> getResponse = restTemplate.getForEntity("/employee/" + createdEmployee.getId(), Employee.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
