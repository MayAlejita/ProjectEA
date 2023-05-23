package finalProject.Service;

import finalProject.domain.Customer;
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
    void addReview(Customer customer, int id);

    List <Review> getReview(int id);
    Review getReviewById(int itemId, int reviewId);

    Item updateItemById(int id);
    Review updateReviewById(int itemId, int reviewId);
}
