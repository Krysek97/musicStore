package com.example.store.item;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

   private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item add(Item item){
        return itemRepository.save(item);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }

    public List<Item> allByCategory(String category){
        return itemRepository.allByCategory(category);
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

}
