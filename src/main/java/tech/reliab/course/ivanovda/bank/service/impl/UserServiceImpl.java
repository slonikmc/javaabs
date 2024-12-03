package tech.reliab.course.ivanovda.bank.service.impl;

import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.service.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public void createUser(int id, String name, LocalDate dateOfBirth, String job) {
        User user = new User(
                id,          // id
                name,        // fullName
                dateOfBirth, // dateOfBirth
                job          // workplace
        );
        users.add(user);
        System.out.println("Пользователь создан:\n" + user);
    }

    @Override
    public void displayUserInfo(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    @Override
    public void updateUser(int id, String name, LocalDate dateOfBirth, String job) {
        User user = findUserById(id);
        if (user != null) {
            user.setFullName(name);
            user.setDateOfBirth(dateOfBirth);
            user.setWorkplace(job);
            System.out.println("Данные пользователя обновлены:\n" + user);
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    @Override
    public void deleteUser(int id) {
        User user = findUserById(id);
        if (user != null) {
            users.remove(user);
            System.out.println("Пользователь с ID " + id + " удалён.");
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }

    // Вспомогательный метод для поиска пользователя по ID
    private User findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
