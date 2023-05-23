package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Order;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;
import finalProject.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapper.map(customerDTO, Customer.class));
        return mapper.map(customer,CustomerDTO.class);
    }

    @Override
    public OrderDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if(customer!=null){
            Order order = mapper.map(orderDTO,Order.class);
            customer.getOrderList().add(order);
            customerRepository.save(customer);
            return mapper.map(order,OrderDTO.class);
        }
       return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = mapper.map(customerList,List.class);
        return customerDTOList;
    }

    @Override
    public CustomerDTO getCustomerById(int idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if(customer!=null){
            return mapper.map(customer,CustomerDTO.class);
        }
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
        List<OrderDTO> list = getOrderByCustomer(idCustomer);
        OrderDTO orderDTO1 = list.stream().filter(id->id.equals(idOrder)).findFirst().get();
        orderDTO1.setStatus(orderDTO.getStatus());
        return mapper.map(orderDTO1,OrderDTO.class);
    }

    @Override
    public void deleteOrderByCustomer(int idCustomer, int idOrder) {

    }
}
