package finalProject.controller;

import finalProject.dto.CustomerDTO;
import finalProject.dto.CustomersDTO;
import finalProject.dto.OrderDTO;
import finalProject.dto.OrdersDTO;
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

//    @PostMapping
//    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO){
//        CustomerDTO customer = customerService.saveCustomer(customerDTO);
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }

    @PostMapping("/{id}/orders") // 1
    public ResponseEntity<?> saveOrderByCustomer(@RequestParam int idCustomer, @RequestBody OrderDTO orderDTO){
        OrderDTO order = customerService.saveOrderByCustomer(idCustomer, orderDTO);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<?> getAllCustomers(){
//        List<CustomerDTO> customerList = customerService.getAllCustomers();
//        CustomersDTO customers = new CustomersDTO();
//        customers.setCustomerDTOList(customerList);
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getCustomerById(@RequestParam int idCustomer){
//        CustomerDTO customer = customerService.getCustomerById(idCustomer);
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}/orders")
//    public ResponseEntity<?> getOrderByCustomer(@RequestParam int idCustomer){
//        List<OrderDTO> order = customerService.getOrderByCustomer(idCustomer);
//        OrdersDTO orders = new OrdersDTO();
//        orders.setOrderDTOList(order);
//        return new ResponseEntity<>(orders, HttpStatus.OK);
//    }

    @PutMapping("/{id}") // 2
    public ResponseEntity<?> updateCustomerById(@RequestParam int idCustomer, @RequestBody CustomerDTO customerDTO){
        CustomerDTO customer = customerService.updateCustomerById(idCustomer, customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PutMapping("/{id}/orders/{idOrders}") //3
    public ResponseEntity<?> updateOrderByCustomer(@RequestParam int idCustomer, @RequestParam int idOrder,@RequestBody OrderDTO orderDTO){
        OrderDTO order = customerService.updateOrderByCustomer(idCustomer, idOrder, orderDTO);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteCustomerById(@RequestParam int idCustomer){
//        customerService.deleteCustomerById(idCustomer);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//    @PutMapping("/{id}/orders/{idOrders}")
//    public ResponseEntity<?> deleteOrderByCustomer(@RequestParam int idCustomer, @RequestParam int idOrder){
//        customerService.deleteOrderByCustomer(idCustomer, idOrder);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
