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
    @RequestMapping(value = "/getBooksByStoreName",method = RequestMethod.POST)
    public ResponseEntity<List<BookDto>> getBooksByStore(@RequestParam(value ="storeName") String storeName){
        return ResponseEntity.ok(bookStoreService.getBooksByStoreName(storeName));
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
