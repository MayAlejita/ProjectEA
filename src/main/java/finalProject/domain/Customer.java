package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "customerId")
    private int id;
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<CreditCard> creditCardList=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private List<Address> addressList=new ArrayList<>();
    @Transient
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Order> orderList = new ArrayList<>();
}
