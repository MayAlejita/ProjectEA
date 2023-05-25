package finalProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import finalProject.domain.Item;
import finalProject.dto.ItemsDTO;
import finalProject.service.ItemService;
import finalProject.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<?> findAllItems() {
        List<ItemDTO> itemDTOList = itemService.getAllItems();
        ItemsDTO items = new ItemsDTO();
        items.setItemDTOList(itemDTOList);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.findItemById(id);
    }

    @PostMapping(value = "",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<?> addItem(@RequestPart("itemDTO") String itemDTO, @RequestPart("imageFile") MultipartFile imageFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ItemDTO item = objectMapper.readValue(itemDTO, ItemDTO.class);
        itemService.addItem(item,imageFile);
        return new ResponseEntity<>(itemDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateItemById(@PathVariable int id, @RequestPart(value = "itemDTO", required = false) String itemDTO,@RequestPart(value = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        if (itemDTO == null) {
            itemDTO = "{}";
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ItemDTO itemDto = objectMapper.readValue(itemDTO, ItemDTO.class);
        Item item = itemService.updateItemById(id, itemDto, imageFile);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/{itemId}/{customerId}")
    public ResponseEntity<?> deleteItem(@PathVariable int itemId, @PathVariable int customerId) {
        itemService.deleteById(itemId, customerId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}
