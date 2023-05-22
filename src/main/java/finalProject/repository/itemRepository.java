package finalProject.repository;

import finalProject.domain.Item;
import finalProject.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itemRepository extends JpaRepository<Item,Integer> {
    Item findById(int id);
    List<Item> findAllByOrder(Order order);
    List<Item> getAllItems();
    void deleteById(int id);
    List<Item> findAllByOrderAndById(Order order, int id);
}
