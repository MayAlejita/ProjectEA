package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderLine> orderLineList;
}
