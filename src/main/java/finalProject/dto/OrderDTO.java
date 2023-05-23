package finalProject.dto;

import finalProject.domain.OrderLine;
import finalProject.domain.Status;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Status status;

    private List<OrderLine> orderLineList;

}
