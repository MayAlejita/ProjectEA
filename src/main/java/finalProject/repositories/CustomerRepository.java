package finalProject.repositories;

import finalProject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    Customer findByOrder(int id);
    List<Customer> findByAddress(String city);
    List<Customer> findByCreditCard(int cardNumber);
    @Query("SELECT c FROM Customer c JOIN FETCH c.creditCardList cc WHERE cc.cardNumber = :cardNumber")
    Customer findByCreditCardNumber(@Param("cardNumber") String cardNumber);

}
