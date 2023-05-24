package finalProject.service;

import finalProject.domain.*;
import finalProject.dto.*;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.ItemRepository;
import finalProject.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    @Transactional
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customerInput;
        if (!validateAddress(customerDTO)) {
            return null;
        }
        if (customerDTO.getClass().getSimpleName().equals("PersonalDTO")) {
            customerInput = mapper.map(customerDTO, Personal.class);
        } else {
            customerInput = mapper.map(customerDTO, Corporate.class);
        }
        Customer customer = customerRepository.save(customerInput);
        return mapper.map(customer, CustomerDTO.class);
    }

    private boolean validateAddress(CustomerDTO customerDTO) {
        long numberShipping = customerDTO.getAddress().stream()
                .filter(a -> a.isDefault() == true && a.getAddressType().getName().equals("shipping")).count();
        if (numberShipping > 1) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public MessageError saveOrderByCustomer(int idCustomer, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        MessageError msg;
        if(customer == null){
            msg = new MessageError();
            msg.setMessage("The customer doesn't exist");
            return msg;
        }
        if(!validateOrderLine(orderDTO)){
            msg = new MessageError();
            msg.setMessage("The Item is duplicated in the same Order");
            return msg;
        }
        Order order = mapper.map(orderDTO, Order.class);
        if(!validateOrderLineQuantity(order)){
            msg = new MessageError();
            msg.setMessage("The quantity of stock is incorrect");
            return msg;
        }
        order.getOrderLineList().stream().forEach(ol -> {
            Optional<Item> item =itemRepository.findById(ol.getItem().getId());
            if(item.isPresent()){
                if(ol.getQuantity() <= item.get().getQuantityStock()){
                    item.get().setQuantityStock(item.get().getQuantityStock() - ol.getQuantity());
                    ol.setItem(item.get());
                }
            }
        });
        customer.getOrderList().add(order);
        customerRepository.save(customer);
        return null;
    }

    private boolean validateOrderLineQuantity(Order order) {
        for(OrderLine ol : order.getOrderLineList()) {
            Optional<Item> item = itemRepository.findById(ol.getItem().getId());
            if(item.isPresent()){
                if(ol.getQuantity() > item.get().getQuantityStock()){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    private boolean validateOrderLine(OrderDTO orderDTO) {
        long numberItem = orderDTO.getOrderLine().stream()
                                .map(a -> a.getItem().getId()).count();
        if (numberItem > 1) {
            return false;
        }
        return true;
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> listCustomer = customerRepository.findAll();
        List<CustomerDTO> list = new ArrayList<>();
        listCustomer.forEach(c -> {
            if(c.getClass().getSimpleName().equals("Personal")){
                list.add(mapper.map(c, PersonalDTO.class));
            }
            else{
                list.add(mapper.map(c, CorporateDTO.class));
            }
        });
        return list;
    }

    @Override
    public CustomerDTO getCustomerById(int idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        if (customer != null) {
            if(customer.getClass().getSimpleName().equals("Personal")){
                return mapper.map(customer, PersonalDTO.class);
            }
            else{
                return mapper.map(customer, CorporateDTO.class);
            }
        }
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByCustomer(int idCustomer) {
        Optional<Customer> customer = customerRepository.findById(idCustomer);
        if(customer.isPresent()){
            List<Order> orderList = customer.get().getOrderList();
            List<OrderDTO> list = new ArrayList<>();
            orderList.forEach(o ->{
                list.add(mapper.map(o, OrderDTO.class));
            });
            return list;
        }
        return null;
    }

    @Override
    public double getTotalByOrder(int idCustomer, int idOrder) {
        return 0;
    }

    @Transactional
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
        }
        return null;
    }

    @Override
    public OrderDTO updateOrderByCustomer(int idCustomer, int idOrder, OrderDTO orderDTO) {
        List<OrderDTO> list = getOrderByCustomer(idCustomer);
        Optional<OrderDTO> orderDTO1 = list.stream().filter(id -> id.getId() == idOrder).findFirst();
        if (orderDTO1.isPresent()) {
            if(orderDTO1.get().getStatus().getStatus().equals("placed")){
                return null;
            }
            orderDTO.setId(orderDTO1.get().getId());
            Order order = mapper.map(orderDTO, Order.class);
            Order orderDB = orderRepository.save(order);
            return mapper.map(orderDB, OrderDTO.class);
        }
        return null;
    }

    @Override
    public Order deleteOrderById(int idOrder) {
        Optional<Order> order = orderRepository.findById(idOrder);
        if (order.isPresent()) {
            orderRepository.deleteById(idOrder);
            return order.get();
        }
        return null;
    }


    public Optional<Customer> findByEmail(String email) {

        return customerRepository.findByEmail(email);
    }
}
