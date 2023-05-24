package finalProject.service;

import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;
import finalProject.dto.ReviewDTO;

import java.util.List;

public interface ItemService {
    Item findItemById(int id);
  
    List<ItemDTO> getAllItems();
  
    void deleteById(int id);

    ItemDTO addItem(ItemDTO item);

    Review addReview(Review review, int customerId, int itemId);

    List<Review> getReviewsByItem(int itemId);

    List<Review> getReviewsByCustomerId(int customerId);

    Review getReviewById(int reviewId);

    Item updateItemById(int id, ItemDTO itemDTO);

    Review updateReviewById(int reviewId, ReviewDTO reviewDTO);
}
