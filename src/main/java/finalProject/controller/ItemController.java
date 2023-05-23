package finalProject.controller;
import finalProject.domain.Item;
import finalProject.service.ItemService;
import finalProject.domain.Review;
import finalProject.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public Page<Item> findAllItems(Pageable pageable) { return itemService.getAllItems(pageable); }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.findItemById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addItem(ItemDTO itemDTO){
        ItemDTO item =  itemService.addItem(itemDTO);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {
        itemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reviews/{itemId}/{customerId}")
    public Review addReview(@PathVariable int itemId, @PathVariable int customerId, @RequestBody Review review) {
        return itemService.addReview(review, itemId, customerId);
    }

    @GetMapping("/reviews/item/{itemId}")
    public List<Review> getReviewsByItemId(@PathVariable int itemId) {
        return itemService.getReviewsByItem(itemId);
    }
    @GetMapping("/reviews/customer/{customerId}")
    public List<Review> getReviewsByCustomerId(@PathVariable int customerId) {
        return itemService.getReviewsByCustomerId(customerId);
    }
    @GetMapping("/reviews/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) {
        return itemService.getReviewById(reviewId);
    }
}
