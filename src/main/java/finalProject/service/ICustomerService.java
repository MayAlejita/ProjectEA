package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Order;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;

import java.util.List;

public interface ICustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    Order saveOrderByCustomer(int idCustomer, Order orderDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(int idCustomer);

    List<OrderDTO> getOrderByCustomer(int idCustomer);

    CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO);
  
    Customer deleteCustomerById(int idCustomer);

    OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO);

    void deleteOrderByCustomer(int idCustomer, int idOrder);
}
