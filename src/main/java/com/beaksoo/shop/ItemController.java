package com.beaksoo.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        itemService.findItem(model);

        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(String title, Integer price) {

        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) throws Exception {


        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("data",result.get());
            return "detail.html";
        }else{
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable Long id) {

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit/{id}")
    String editItem(String title, Integer price, Long id) {
        itemService.editItem(title, price, id);

        return "redirect:/list";
    }



}



