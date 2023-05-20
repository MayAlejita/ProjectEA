package finalProject.domain;

import java.util.List;

public class OrderLine {
    private int id;
    private int quantity;
    private boolean discount;
    private double discountValue;
    private List<Item> itemList;
}
