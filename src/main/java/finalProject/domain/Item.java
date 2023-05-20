package finalProject.domain;

import java.util.List;

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;//TODO
    private String barcodeNumber;
    private int quantityStock;
    private List<Review> reviewList;
    private List<Item> itemList;

}
