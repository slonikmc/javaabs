package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.service.UserService;

import java.time.LocalDate;

public class UserServiceImpl implements UserService {
    private User user;

    @Override
    public void createUser(int id, String name, LocalDate dateOfBirth, String job) {
        User user = new User(
                id,                                // id
                name,                              // fullName
                LocalDate.of(1990, 1, 1),          // dateOfBirth (например, 1 января 1990 года)
                "Software Developer"               // workplace (например, "Software Developer")
        );

        System.out.println("Пользователь создан:\n" + user);
    }

    @Override
    public void displayUserInfo(int id) {
        if (user != null && user.getId() == id) {
            System.out.println(user);
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateUser(int id, String name, LocalDate dateOfBirth, String job) {
        if (user != null && user.getId() == id) {
            user.setWorkplace(job);
            user.setFullName(name);
            user.setDateOfBirth(dateOfBirth);
            System.out.println("Данные пользователя обновлены");
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteUser(int id) {
        if (user != null && user.getId() == id) {
            user = null;
            System.out.println("Пользователь с ID " + id + " удалён.");
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }
}
