package finalProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private int id;
    private StatusDTO status;
    private List<OrderLineDTO> orderLine;
    private CustomerDTO customer;
}
