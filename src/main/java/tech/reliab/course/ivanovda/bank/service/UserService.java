package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    /**
     * Создает нового пользователя с указанным идентификатором, именем, датой рождения и работой.
    */
    void createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void updateUser(int id, User updatedUser);

    /**
     * Удаляет пользователя с указанным идентификатором.
     *
     * @param id идентификатор пользователя
     */
    void deleteUser(int id);
}
