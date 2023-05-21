package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    private boolean discount;
    private double discountValue;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itemList;

    public OrderLine(int quantity, boolean discount, double discountValue) {
        this.quantity = quantity;
        this.discount = discount;
        this.discountValue = discountValue;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Item item) {
        this.itemList.add(item);
    }
}
