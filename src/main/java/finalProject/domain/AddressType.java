package finalProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressType {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public AddressType(String name) {
        this.name = name;
    }
}
