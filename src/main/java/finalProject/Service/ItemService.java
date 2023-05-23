package finalProject.Service;

import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Item findItemById(int id);
    Page<Item> getAllItems(Pageable pageable);
    void deleteById(int id);
    ItemDTO addItem(ItemDTO item);
    Review addReview(Review review, int customerId, int itemId);

    List <Review> getReviewsByItem(int itemId);

    List<Review> getReviewsByCustomerId(int customerId);
    Review getReviewById(int reviewId);

    Item updateItemById(int id);
    Review updateReviewById(int itemId, int reviewId);
}
