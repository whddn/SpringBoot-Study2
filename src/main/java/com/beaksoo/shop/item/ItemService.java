package com.beaksoo.shop.item;

import com.beaksoo.shop.item.Item;
import com.beaksoo.shop.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }

    public void findItem(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);
    }

    public void editItem(String title, Integer price, Long id){
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);
    }




}
