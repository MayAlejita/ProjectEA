package finalProject.dto;

import finalProject.domain.Address;
import finalProject.domain.CreditCard;
import finalProject.domain.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDTO extends OrderDTO {
    private int id;
    private String emailAddress;
    private List<CreditCard> creditCardList=new ArrayList<>();
    private List<Address> addressList=new ArrayList<>();
    private List<Order> orderList = new ArrayList<>();
}
