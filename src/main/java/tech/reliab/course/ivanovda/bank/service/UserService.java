package tech.reliab.course.ivanovda.bank.service;

import tech.reliab.course.ivanovda.bank.entity.User;

import java.time.LocalDate;

public interface UserService {

    /**
     * Создает нового пользователя с указанным идентификатором, именем, датой рождения и работой.
     *
     * @param id            идентификатор пользователя
     * @param name          имя пользователя
     * @param dateOfBirth   дата рождения пользователя
     * @param job           место работы пользователя
     */
    void createUser(int id, String name, LocalDate dateOfBirth, String job);

    /**
     * Выводит информацию о пользователе с указанным идентификатором.
     *
     * @param id идентификатор пользователя
     */
    void displayUserInfo(int id);

    /**
     * Обновляет информацию о пользователе, включая имя, дату рождения и место работы.
     *
     * @param id            идентификатор пользователя
     * @param name          новое имя пользователя
     * @param dateOfBirth   новая дата рождения пользователя
     * @param job           новое место работы пользователя
     */
    void updateUser(int id, String name, LocalDate dateOfBirth, String job);

    /**
     * Удаляет пользователя с указанным идентификатором.
     *
     * @param id идентификатор пользователя
     */
    void deleteUser(int id);
}
