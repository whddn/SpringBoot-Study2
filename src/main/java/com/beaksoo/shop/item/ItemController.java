package com.beaksoo.shop.item;

import com.beaksoo.shop.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final S3Service s3Service;

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

        CommentRepository.findAllByParentId(1L);

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
        return "redirect:/error";

        }
        return "redirect:/list";
    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id){
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }

    @GetMapping("/list/page/{abc}")
    String getListPage(Model model, @PathVariable Integer abc) {

        Page<Item> result = itemRepository.findPageBy(PageRequest.of(abc-1,5));
        result.getTotalPages();
        System.out.println(result.getTotalPages());
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/presigned-url")
    @ResponseBody
    String getURL(@RequestParam String filename){
        var result = s3Service.createPreSignedUrl("test/" + filename);
        System.out.println(result);
        return result;
    }

    @GetMapping ("/search")
    String postSearch(@RequestParam String searchText){

        var result = itemRepository.rawQuery1(searchText);
        System.out.println(result);

        return "list.html";
    }







}



