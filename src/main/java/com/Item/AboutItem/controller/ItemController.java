package com.Item.AboutItem.controller;

import com.Item.AboutItem.exception.ResourceNotFoundException;
import com.Item.AboutItem.domain.Item;
import com.Item.AboutItem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/item/v1")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
        return ResponseEntity.ok().body(item);
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
                                           @RequestBody Item itemDetails) throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("item not found for this id :: " + itemId));

        item.setItemName(itemDetails.getItemName());
        item.setItemDescription(itemDetails.getItemDescription());
        item.setItemNumber(itemDetails.getItemNumber());
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/item/{id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long itemId)
            throws ResourceNotFoundException {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
