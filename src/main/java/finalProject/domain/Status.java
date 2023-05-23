package finalProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Status {
    @Id
    @GeneratedValue
    private int id;
    private String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
