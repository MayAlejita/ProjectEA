package finalProject.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import finalProject.dto.CustomerDTO;
import finalProject.service.CustomerService;

import javax.security.auth.login.AccountException;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountException.class)
public class CustomerControllerTest {
    @Autowired
    MockMvc mock;

   @MockBean
    CustomerService customerService;

   @MockBean
    CustomerRepository customerRepository;

   @Test
    public void testGetCustomer() throws Exception {
      // Mockito.when(customerService.getCustomerById(1)).thenReturn(new CustomerDTO(1));
       mock.perform(MockMvcRequestBuilders.get("/customer"))
               .andExpect((ResultMatcher) MockMvcResultMatchers.jsonPath("1"));
   }



}
