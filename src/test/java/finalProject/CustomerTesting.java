package finalProject;

import finalProject.domain.Customer;
import finalProject.repositories.CustomerRepository;
import finalProject.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.hamcrest.Matchers.*;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
public class CustomerTesting {
    @TestConfiguration
    static class customerServiceTestImpl {
        @Bean
        public CustomerService customerService() {
            return new CustomerService();
        }
        @Bean
        ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Autowired
    CustomerService customerService;

    @MockBean
    CustomerRepository customerRepo;

    @Before
    public void setUp() {
        String email = "email1@email.com";
        Optional<Customer> customer = Optional.of(new Customer("email1@email.com"));
        Mockito.when(customerRepo.findByEmail(email))
                .thenReturn(customer);
    }
    @Test
    public void WhenValidEmail() {
        String email = "email1@email.com";
        Optional<Customer> found = customerService.findByEmail(email);
        if (found.isPresent())
         assertThat(found.get().getEmailAddress(), equalTo(email));
        else assertThat(true, equalTo(false));
}

}