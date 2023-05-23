package finalProject.repositories;

import finalProject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository extends JpaRepository<Review,Integer> {
}
