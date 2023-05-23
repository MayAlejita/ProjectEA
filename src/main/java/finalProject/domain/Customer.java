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
public abstract class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<CreditCard> creditCardList=new ArrayList<CreditCard>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Address> addressList=new ArrayList<Address>();
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Order> orderList = new ArrayList<Order>();

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(CreditCard creditCard) {
        this.creditCardList.add(creditCard);
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList( Address address) {
        this.addressList.add(address);
    }
}
