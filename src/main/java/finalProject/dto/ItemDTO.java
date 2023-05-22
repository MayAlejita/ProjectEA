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
}
