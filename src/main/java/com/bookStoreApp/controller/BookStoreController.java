package com.bookStoreApp.controller;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.dto.BookStoreDto;
import com.bookStoreApp.service.BookStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }


    @GetMapping
    public ResponseEntity<List<BookStoreDto>> tumunuListele(){

        return ResponseEntity.ok(bookStoreService.getAll());
    }

    @PostMapping
    public ResponseEntity<BookStoreDto> kaydet(@RequestBody BookStoreDto bookStoreDto){
        return ResponseEntity.ok(bookStoreService.save(bookStoreDto));
    }

    @PostMapping(value = "/getDataByCategoryName")
    public ResponseEntity<BookDto> saveBookToBookStore(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookStoreService.saveBookToBookStore(bookDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity guncelle(@PathVariable(value = "id",required = true) int id, @RequestBody BookStoreDto bookStoreDto) {
        return ResponseEntity.ok(bookStoreService.update(id, bookStoreDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id",required = true) int id){
        return ResponseEntity.ok(bookStoreService.delete(id));
    }
}
