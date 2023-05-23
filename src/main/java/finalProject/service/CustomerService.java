package finalProject.service;

import finalProject.domain.Customer;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;
import finalProject.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapper.map(customerDTO, Customer.class));
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> listCustomer = customerRepository.findAll();
        listCustomer.stream().map(e -> mapper.map(e, CustomerDTO.class));
        return listCustomer.stream().map(e -> mapper.map(e, CustomerDTO.class))
                .collect(Collectors.toList());
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
