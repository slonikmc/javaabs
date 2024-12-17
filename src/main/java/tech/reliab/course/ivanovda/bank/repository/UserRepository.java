package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
