package com.example.store.item;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public Item add(Item item){
        return itemService.add(item);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        itemService.deleteById(id);
    }

    @GetMapping("/{category}")
    public List<Item> allByCategory(@PathVariable String category){
        return itemService.allByCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Item> findById(Long id){
        return itemService.findById(id);
    }

}
