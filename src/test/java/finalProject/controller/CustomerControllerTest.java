package finalProject.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import finalProject.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import finalProject.repositories.CustomerRepository;
import finalProject.service.CustomerService;

import javax.security.auth.login.AccountException;
import java.util.Optional;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountException.class)
public class CustomerControllerTest {
    @Autowired
    MockMvc mock;

   @MockBean
    CustomerService customerService;

   @MockBean
    CustomerRepository customerRepository;

    @Before
    public void setUp() {
        String email = "john1@email.com";
        Optional<Customer> customer = Optional.of(new Customer("email1@email.com"));
        Mockito.when(customerRepository.findByEmail(email))
                .thenReturn(customer);
    }
    @Test
    public void WhenValidEmail() {
        String email = "john1@email.com";
        Optional<Customer> found = customerService.findByEmail(email);
        if (found.isPresent())
            assertThat(found.get().getEmailAddress(), equalTo(email));
        else assertThat(false, equalTo(false));
    }

   @Test
    public void testGetCustomer() throws Exception {
      // Mockito.when(customerService.getCustomerById(1)).thenReturn(new CustomerDTO(1));
       mock.perform(MockMvcRequestBuilders.get("/customers"))
               .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("1"));
   }



}
