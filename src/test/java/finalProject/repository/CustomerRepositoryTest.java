package finalProject.repository;

import finalProject.domain.Customer;
import finalProject.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void setCustomerRepository(){
        Customer customer = new Customer();
        entityManager.persist(customer);
        entityManager.flush();

        // when
        Customer found = customerRepository.findById();


        // and
        assertThat(customer.getAddressList())
                .isEqualTo(found.getAddressList());
        // and
        assertThat(customer.getCreditCardList())
                .isEqualTo(found.getCreditCardList());

    }
}
