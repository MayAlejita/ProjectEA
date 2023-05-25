package finalProject.service;

import finalProject.domain.Item;
import finalProject.dto.ItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ItemService {
    Item findItemById(int id);
  
    List<ItemDTO> getAllItems();
  
    void deleteById(int id, int customerId);

    ItemDTO addItem(ItemDTO item, MultipartFile imageFile) throws IOException;

    Item updateItemById(int id, ItemDTO itemDTO, MultipartFile imageFile) throws IOException;

}
