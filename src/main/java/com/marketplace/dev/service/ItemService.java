package com.marketplace.dev.service;

import com.marketplace.dev.entity.Item;
import com.marketplace.dev.repository.ItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public void saveItem(final Item item){
        LOGGER.info("Creating item with title: " + item.getItemTitle());

        itemRepository.save(item);
    }

    public List<Item> findAllItems(){
        LOGGER.info("Retrieving all item...");

        final List<Item> items = new ArrayList<Item>();
        itemRepository.findAll().forEach(item -> items.add(item));

        return items;
    }

    public Item findItem(final int id){
        LOGGER.info("Searching for item with id: " + id);

        Optional<Item> item = itemRepository.findById(id);

        if(item.isPresent()){
            return item.get();
        }
        else
        {
            throw new RuntimeException("ERROR: Could no find item with id: " + id);
        }
    }

    public void updateItem(final Item item){
        LOGGER.info("Updating item with id: " + item.getItemID());
        itemRepository.save(item);
    }

    public void deleteItem(final int id){
        LOGGER.info("Deleting item with id " + id);
        itemRepository.deleteById(id);
    }
}
