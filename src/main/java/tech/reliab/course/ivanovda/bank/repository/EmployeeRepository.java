package tech.reliab.course.ivanovda.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ivanovda.bank.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
