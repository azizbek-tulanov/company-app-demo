package uz.pdp.vazifa_1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.vazifa_1.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
