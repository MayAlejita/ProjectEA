package finalProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue
    private int id;
    private int numberCard;
    private String expirationDate;
    private String securityCode;

    public CreditCard(int numberCard, String expirationDate, String securityCode) {
        this.numberCard = numberCard;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }
}
