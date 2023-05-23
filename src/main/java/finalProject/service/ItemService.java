package finalProject.service;

import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    Item findItemById(int id);
    List<ItemDTO> getAllItems();
    void deleteById(int id);
    ItemDTO addItem(ItemDTO item);
    Review addReview(Review review, int customerId, int itemId);

    List <Review> getReviewsByItem(int itemId);

    List<Review> getReviewsByCustomerId(int customerId);
    Review getReviewById(int reviewId);

    Item updateItemById(int id);
    Review updateReviewById(int itemId, int reviewId);
}
