package finalProject.controller;
import finalProject.domain.Item;
import finalProject.Service.ItemService;
import finalProject.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


}
