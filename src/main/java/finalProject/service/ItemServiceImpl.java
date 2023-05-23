package finalProject.Service;

import finalProject.domain.Customer;
import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;


    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public Page<Item> getAllItems(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void addItem() {

    }

    @Override
    public void addReview(Customer customer, int id) {

    }

    @Override
    public List<Review> getReview(int id) {
        return null;
    }

    @Override
    public Review getReviewById(int itemId, int reviewId) {
        return null;
    }

    @Override
    public Item updateById(int id) {
        return null;
    }

    @Override
    public Review updateReviewById(int itemId, int reviewId) {
        return null;
    }
}
