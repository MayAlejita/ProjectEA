package finalProject.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private int numberStar;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Review(String title, String description, int numberStar, LocalDate date, Customer customer) {
        this.title = title;
        this.description = description;
        this.numberStar = numberStar;
        this.date = date;
        this.customer = customer;
    }
}
