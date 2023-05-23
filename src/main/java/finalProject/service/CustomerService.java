package finalProject.service;

import finalProject.domain.Corporate;
import finalProject.domain.Customer;
import finalProject.domain.Order;
import finalProject.domain.Personal;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;
import finalProject.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customerInput;
        if(!validateAddress(customerDTO)){
            return null;
        }
        if(customerDTO.getClass().getSimpleName().equals("PersonalDTO")){
            customerInput = mapper.map(customerDTO, Personal.class);
        }
        else{
            customerInput = mapper.map(customerDTO, Corporate.class);
        }
        Customer customer = customerRepository.save(customerInput);
        return mapper.map(customer, CustomerDTO.class);
    }

    private boolean validateAddress(CustomerDTO customerDTO) {
        long numberShipping = customerDTO.getAddress().stream()
                .filter(a -> a.isDefault() == true && a.getAddressType().getName().equals("shipping")).count();
        if(numberShipping > 1){
            return false;
        }
        return true;
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
        List<Customer> listCustomer = customerRepository.findAll();
        List<CustomerDTO> list = new ArrayList<>();
        listCustomer.forEach(c ->{
            list.add(mapper.map(c, CustomerDTO.class));
        });
        return list;
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
