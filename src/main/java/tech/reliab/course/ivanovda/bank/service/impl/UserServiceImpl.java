package tech.reliab.course.ivanovda.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.reliab.course.ivanovda.bank.entity.User;
import tech.reliab.course.ivanovda.bank.repository.UserRepository;
import tech.reliab.course.ivanovda.bank.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
        System.out.println("Пользователь создан: " + user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с ID " + id + " не найден."));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setWorkplace(updatedUser.getWorkplace());
        existingUser.setMonthlyIncome(updatedUser.getMonthlyIncome());
        existingUser.setBank(updatedUser.getBank());
        existingUser.setCreditAccount(updatedUser.getCreditAccount());
        existingUser.setPaymentAccount(updatedUser.getPaymentAccount());
        userRepository.save(existingUser);
        System.out.println("Пользователь обновлен: " + existingUser);
    }

    @Override
    public void deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            System.out.println("Пользователь с ID " + id + " удален.");
        } else {
            System.out.println("Пользователь с ID " + id + " не найден.");
        }
    }
}
