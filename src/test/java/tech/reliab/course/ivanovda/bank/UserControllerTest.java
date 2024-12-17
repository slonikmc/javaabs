package tech.reliab.course.ivanovda.bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import tech.reliab.course.ivanovda.bank.entity.User;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateUser() {
        User newUser = new User();
        newUser.setFullName("Test User");

        ResponseEntity<User> response = restTemplate.postForEntity("/users", newUser, User.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFullName()).isEqualTo("Test User");
    }

    @Test
    void testGetAllUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("/users", User[].class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    void testGetUserById() {
        User newUser = new User();
        newUser.setFullName("Test User");
        User createdUser = restTemplate.postForObject("/users", newUser, User.class);

        ResponseEntity<User> response = restTemplate.getForEntity("/users/" + createdUser.getId(), User.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getFullName()).isEqualTo("Test User");
    }

    @Test
    void testDeleteUser() {
        User newUser = new User();
        newUser.setFullName("User to Delete");
        User createdUser = restTemplate.postForObject("/users", newUser, User.class);

        restTemplate.delete("/users/" + createdUser.getId());

        ResponseEntity<User> response = restTemplate.getForEntity("/users/" + createdUser.getId(), User.class);
        assertThat(response.getStatusCode().is4xxClientError()).isTrue(); // User not found
    }
}
