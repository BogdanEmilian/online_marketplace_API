package com.marketplace.dev.controller;

import com.marketplace.dev.entity.Item;
import com.marketplace.dev.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/")
    public List<Item> getItems(){
        return itemService.findAllItems();
    }

    @PostMapping(path = "/add/{title}/{description}/{price}")
    public void createItem(@PathVariable String title, @PathVariable String description, @PathVariable float price) {
        itemService.saveItem(new Item(title, description, price));
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.findItem(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable int id, @RequestBody Item item) {
        Item existingItem = itemService.findItem(id);
        existingItem.setItemTitle(item.getItemTitle());
        existingItem.setItemDescription(item.getItemDescription());
        existingItem.setItemPrice(item.getItemPrice());
        itemService.updateItem(existingItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}