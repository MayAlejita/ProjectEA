package finalProject.domain;

import jakarta.persistence.Entity;

@Entity
public class Personal extends Customer{
    private String firstname;
    private String lastname;
}
