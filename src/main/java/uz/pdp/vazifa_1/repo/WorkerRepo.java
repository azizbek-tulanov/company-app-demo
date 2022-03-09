package uz.pdp.vazifa_1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.vazifa_1.entity.Worker;

@Repository
public interface WorkerRepo extends JpaRepository<Worker,Integer> {
}
