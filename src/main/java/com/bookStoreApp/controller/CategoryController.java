package com.bookStoreApp.controller;

import com.bookStoreApp.dto.CategoryDto;
import com.bookStoreApp.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value = "BookStore Api Dökümantasyonu.")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ApiOperation(value = "Tüm kategorileri getirme metodu.")
    public ResponseEntity<List<CategoryDto>> tumunuListele(){

        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping
    @ApiOperation(value = "Yeni Book metodu.")
    public ResponseEntity<CategoryDto> kaydet(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity guncelle(@PathVariable(value = "id",required = true) int id, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.update(id, categoryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id",required = true) int id){
        return ResponseEntity.ok(categoryService.delete(id));
    }
}
