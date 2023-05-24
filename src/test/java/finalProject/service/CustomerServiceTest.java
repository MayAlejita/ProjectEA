package finalProject.service;

import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import finalProject.domain.Customer;
import finalProject.repositories.CustomerRepository;
import static org.hamcrest.Matchers.equalTo;
import java.util.Optional;


@RunWith(SpringRunner.class)
public class CustomerServiceTest {
@TestConfiguration
static class AccountServiceImplTestContextConfiguration {

    @Bean
    public CustomerService accountService() {
        return new CustomerService();
    }
}

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        String email = "email1@email.com";
        Optional<Customer> customer = Optional.of(new Customer("email1@email.com"));
        Mockito.when(customerRepository.findByEmail(email))
                .thenReturn(customer);
    }

    @Test
    public void getCustomerByIdTest() {
        String email = "email1@email.com";
        Optional<Customer> found = customerService.findByEmail(email);
        if (found.isPresent())
            MatcherAssert.assertThat(found.get().getEmailAddress(), equalTo(email));
        else MatcherAssert.assertThat(true, equalTo(false));

    }

}
