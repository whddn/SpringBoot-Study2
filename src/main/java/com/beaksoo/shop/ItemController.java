package com.beaksoo.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        System.out.println(result.get(0).price);



        model.addAttribute("name", "비싼 바지");
        return "list.html";
    }

}

