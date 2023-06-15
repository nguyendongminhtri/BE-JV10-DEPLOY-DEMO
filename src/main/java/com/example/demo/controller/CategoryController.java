package com.example.demo.controller;

import com.example.demo.dto.response.ResponMessage;
import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> showListCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        if (categoryService.existsByName(category.getName())){
            return  new ResponseEntity<>(new ResponMessage("name_exist"), HttpStatus.OK);
        }
        categoryService.save(category);
        return  new ResponseEntity<>(new ResponMessage("success"), HttpStatus.OK);
    }
}
