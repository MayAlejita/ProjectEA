package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Order;
import finalProject.dto.CustomerDTO;
import finalProject.dto.OrderDTO;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository OrderRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(mapper.map(customerDTO, Customer.class));
        return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
         Order order = mapper.map(orderDTO, Order.class);
         customer.setOrderList(order);
           customerRepository.save(customer);
        return mapper.map(customer, CustomerDTO.class);


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
       // List<CustomerDTO> customerDTOList=customerRepository.findAll();
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = mapper.map(customerList,List.class);
        return customerDTOList;
    }

    @Override
    public CustomerDTO getCustomerById(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if(customer.isPresent()){
            return mapper.map(customer, CustomerDTO.class);
        }
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByCustomer(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if(customer.isPresent()){
            List<Order> orderList = customer.get().getOrderList();
            return mapper.map(orderList, List.class);
        }
        return null;
    }

    @Override
    public CustomerDTO updateCustomerById(int idCustomer, CustomerDTO customerDTO) {
       Customer customer= customerRepository.findById(idCustomer).orElse(null);

       if(customer!=null){
           customer.setEmailAddress(customerDTO.getEmailAddress());
       }
       return mapper.map(customer, CustomerDTO.class);
    }

    @Override
    public Customer deleteCustomerById(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if (customer.isPresent()) {
            customerRepository.deleteById(idCustomer);
            return customer.get();
        } else
            return null;

    }

    @Override
    public OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO) {
       List<OrderDTO> list=  getOrderByCustomer(idCustomer);
       OrderDTO orderDTO1= list.stream().filter(id->id.equals(idOrder)).findFirst().get();
       orderDTO1.setStatus(orderDTO.getStatus());
        return mapper.map(orderDTO1, OrderDTO.class);
    }

    @Override
    public void deleteOrderByCustomer(int idCustomer, int idOrder) {

        Customer  customer= customerRepository.findById(idCustomer).orElse(null);
        List<Order> orderList= customer.getOrderList();
        Order order= orderList.stream().filter(id->id.equals(idOrder)).findFirst().get();
        orderList.remove(order);
//
//        List<OrderDTO> list=  getOrderByCustomer(idCustomer);
//        OrderDTO orderDTO= list.stream().filter(id->id.equals(idOrder)).findFirst().get();
//        list.remove(orderDTO);



    }
}
