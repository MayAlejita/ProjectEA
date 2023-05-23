package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "")
    private List<OrderLine> orderLineList;
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    private Customer customer;

    public Order( Customer customer) {
        this.customer = customer;
        this.orderLineList = new ArrayList<>();
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(OrderLine order) {
        this.orderLineList.add(order);
    }
}
