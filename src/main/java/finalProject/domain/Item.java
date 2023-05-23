package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;//TODO
    private String barcodeNumber;
    private int quantityStock;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private List<Review> reviewList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Item> itemList = new ArrayList<Item>();

    public Item(String name, String description, double price, String image, String barcodeNumber, int quantityStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.barcodeNumber = barcodeNumber;
        this.quantityStock = quantityStock;

    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(Review review) {
        this.reviewList.add(review);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Item item) {
        this.itemList.add(item);
    }
}
