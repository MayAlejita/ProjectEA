package finalProject.repositories;

import finalProject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    void deleteOrderById(int idOrder);
}
