package finalProject.repositories;

import finalProject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderrepository extends JpaRepository<Order,Integer> {
}
