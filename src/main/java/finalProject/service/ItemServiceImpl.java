package finalProject.service;

import finalProject.domain.Customer;
import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;
import finalProject.repositories.CustomerRepository;
import finalProject.repositories.ItemRepository;
import finalProject.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Item findItemById(int itemId) {
        return mapper.map(itemRepository.findById(itemId).get(),
                Item.class);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> listItems = itemRepository.findAll();
        listItems.stream().map(e -> mapper.map(e, ItemDTO.class));
        return listItems.stream().map(e -> mapper.map(e, ItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = itemRepository.save(mapper.map(itemDTO, Item.class));
        return mapper.map(item, ItemDTO.class);
    }

    @Override
    public Review addReview(Review review, int customerId, int itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item not found"));
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        review.setItem(item);
        review.setCustomer(customer);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByItem(int itemId) {
        return reviewRepository.findByItemId(itemId);
    }

    @Override
    public List<Review> getReviewsByCustomerId(int customerId) {
        return reviewRepository.findByCustomerId(customerId);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }

    @Override
    public Item updateItemById(int id) {
        return null;
    }

    @Override
    public Review updateReviewById(int itemId, int reviewId) {
        return null;
    }

}
