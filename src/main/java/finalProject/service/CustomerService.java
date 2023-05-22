package finalProject.service;

import finalProject.domain.Customer;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;

import java.util.List;

public class CustomerService implements ICustomerService{

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return new CustomerDTO();
    }

    @Override
    public OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public CustomerDTO getCustomerById(int idCustomer) {
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByCustomer(int idCustomer) {
        return null;
    }

    @Override
    public CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomerById(int idCustomer) {

    }

    @Override
    public OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrderByCustomer(int idCustomer, int idOrder) {

    }
}
