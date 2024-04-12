package com.beaksoo.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    String detail(@PathVariable Long id, Model model){

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            model.addAttribute("data", result.get());
            return "detail.html";
        }else {
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

    @PostMapping("/edit")
    String editItem(String title, Integer price, Long id) {
        itemService.editItem(title, price, id);
        if(title.length() >= 100 || price < 0){

        }
        return "redirect:/error";
    }



}



