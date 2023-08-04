package com.misc.simplecrudapi;
import java.util.NoSuchElementException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misc.simplecrudapi.model.Item;



@RestController
@RequestMapping("/model/Item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id){
        return itemRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Item not Found!"));
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Item not Found!"));

        item.setName(updatedItem.getName());
        item.setDescription(updatedItem.getDescription());

        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
   
    
}
