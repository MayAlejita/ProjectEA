package finalProject.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomersDTO {
    private List<CustomerDTO> customerDTOList = new ArrayList<>();

    public void setCustomerDTOList(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }
}
