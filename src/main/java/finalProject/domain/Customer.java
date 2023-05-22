package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private List<CreditCard> creditCardList=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private List<Address> addressList=new ArrayList<>();

    public Customer(String firstname, String lastname, String emailAddress) {
        this.firstname = firstname;
        this.lastname = lastname;
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
