package finalProject.dto;

import finalProject.domain.Item;
import finalProject.domain.Review;

import java.util.List;

public class ItemDTO {
    private String name;
    private String description;
    private double price;
    private String barcodeNumber;
    private int quantityStock;
    private List<Review> reviewList;
    private List<Item> itemList;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBarcodeNumber(String barcodeNumber) {
        this.barcodeNumber = barcodeNumber;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public ItemDTO(String name, String description, double price, String barcodeNumber, int quantityStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.barcodeNumber = barcodeNumber;
        this.quantityStock = quantityStock;
    }
}
