package com.example.store.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public Item add(@RequestBody Item item){
        return itemService.add(item);
    }
    @GetMapping("/all")
    public List<Item> all(){
        return itemService.all();
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        itemService.deleteById(id);
    }

    @GetMapping("/category/{category}")
    public List<Item> allByCategory(@PathVariable Category category){
        return itemService.allByCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable  Long id){
        return itemService.findById(id);
    }



}
