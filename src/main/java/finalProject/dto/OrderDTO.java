package finalProject.dto;

import finalProject.domain.Customer;
import finalProject.domain.OrderLine;
import finalProject.domain.Status;
import jakarta.persistence.CascadeType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class OrderDTO {
    private Status status;
    private List<OrderLine> orderLineList;
}
