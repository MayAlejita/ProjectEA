package finalProject.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Status {
    private int id;
    private String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
