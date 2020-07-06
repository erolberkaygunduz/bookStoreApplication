package com.bookStoreApp.controller;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.dto.CategoryDto;
import com.bookStoreApp.entity.Book;
import com.bookStoreApp.entity.Category;
import com.bookStoreApp.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> tumunuListele(){

        return ResponseEntity.ok(categoryService.getAll());
    }
    @RequestMapping(value = "/getDataByCategoryName",method = RequestMethod.POST)
    public ResponseEntity<List<BookDto>> getBooksByCategory(@RequestParam(value ="categoryName") String categoryName){
        return ResponseEntity.ok(categoryService.getBooksByCategoryName(categoryName));
    }


    @PostMapping
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
