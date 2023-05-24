package finalProject.service;

import finalProject.domain.Item;
import finalProject.dto.ItemDTO;
import finalProject.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Item updateItemById(int id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        if(itemDTO.getName() != null) {
            item.setName(itemDTO.getName());
        }
        if(itemDTO.getPrice() != 0) {
            item.setPrice(itemDTO.getPrice());
        }
        if(itemDTO.getBarcodeNumber() != null) {
            item.setBarcodeNumber(itemDTO.getBarcodeNumber());
        }
        if(itemDTO.getImage() != null) {
            item.setImage(itemDTO.getImage());
        }
        if(itemDTO.getDescription() != null) {
            item.setDescription(itemDTO.getDescription());
        }
        if(itemDTO.getQuantityStock() != 0) {
            item.setQuantityStock(itemDTO.getQuantityStock());
        }
        return itemRepository.save(item);
    }
}
