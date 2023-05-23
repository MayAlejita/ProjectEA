package finalProject.service;

import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(int idCustomer);
    List<OrderDTO> getOrderByCustomer(int idCustomer);
    CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO);
    void deleteCustomerById(int idCustomer);
    OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO);
    void deleteOrderByCustomer(int idCustomer, int idOrder);
}
