package finalProject.Service;

import finalProject.domain.Customer;
import finalProject.domain.Item;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;
import finalProject.repositories.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Item findItemById(int itemId) {
        return mapper.map(itemRepository.findById(itemId).get(),
                Item.class);
    }

    @Override
    public Page<Item> getAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
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
    public Item updateItemById(int id) {
        return null;
    }

    @Override
    public Review updateReviewById(int itemId, int reviewId) {
        return null;
    }

}
