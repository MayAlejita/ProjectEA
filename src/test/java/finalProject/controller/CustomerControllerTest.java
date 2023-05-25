package finalProject.controller;

import finalProject.dto.CustomerDTO;
import finalProject.service.CustomerService;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.security.auth.login.AccountException;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountException.class)
public class CustomerControllerTest {
    @Autowired
    MockMvc mock;

    @MockBean
    CustomerService customerService;

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(9000);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }
    @Test
    public void testGetCustomer() throws Exception {

        CustomerDTO customer = new CustomerDTO();
        int id = 1;
        String email = "email";
        customer.setId(id);
        customer.setEmailAddress(email);

        Mockito.when(customerService.saveCustomer(customer))
                .thenReturn(customer);

        given()
                .contentType("application/json")
                .when().get("/customers").then()
                .statusCode(200);
    }

    @Test
    public void testGetCustomerById() throws Exception {
        CustomerDTO customer = new CustomerDTO();
        int id = 1;
        customer.setId(id);
        customer.setEmailAddress("mail");
        Mockito.when(customerService.getCustomerById(id))
                .thenReturn(customer);
        given()
                .contentType("application/json")
                .when().get("/customers/1").then()
                .statusCode(200);


    }
}
