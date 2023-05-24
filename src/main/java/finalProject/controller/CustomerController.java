package finalProject.controller;

import finalProject.domain.Customer;
import finalProject.dto.*;
import finalProject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.saveCustomer(customerDTO);
        if (customer == null) {
            MessageError msg = new MessageError();
            msg.setMessage("Only choice one default shipping Address");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/{idCustomer}/orders")
    public ResponseEntity<?> saveOrderByCustomer(@PathVariable int idCustomer, @RequestBody OrderDTO orderDTO) {
        OrderDTO order = customerService.saveOrderByCustomer(idCustomer, orderDTO);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerDTO> customerList = customerService.getAllCustomers();
        CustomersDTO customers = new CustomersDTO();
        customers.setCustomerDTOList(customerList);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<?> getCustomerById(@PathVariable int idCustomer) {
        CustomerDTO customer = customerService.getCustomerById(idCustomer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}/orders")
    public ResponseEntity<?> getOrderByCustomer(@PathVariable int idCustomer){
        List<OrderDTO> order = customerService.getOrderByCustomer(idCustomer);
        OrdersDTO orders = new OrdersDTO();
        orders.setOrderDTOList(order);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping("/{idCustomer}")
    public ResponseEntity<?> updateCustomerById(@PathVariable int idCustomer, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.updateCustomerById(idCustomer, customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{idCustomer}/orders/{idOrder}")
    public ResponseEntity<?> updateOrderByCustomer(@PathVariable int idCustomer, @PathVariable int idOrder, @RequestBody OrderDTO orderDTO) {
        OrderDTO order = customerService.updateOrderByCustomer(idCustomer, idOrder, orderDTO);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{idCustomer}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int idCustomer) {
        Customer customer = customerService.deleteCustomerById(idCustomer);
        if (customer == null) {
            MessageError msg = new MessageError();
            msg.setMessage("Customer doesn't exist");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PutMapping("/{id}/orders/{idOrders}")
//    public ResponseEntity<?> deleteOrderByCustomer(@RequestParam int idCustomer, @RequestParam int idOrder){
//        customerService.deleteOrderByCustomer(idCustomer, idOrder);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
