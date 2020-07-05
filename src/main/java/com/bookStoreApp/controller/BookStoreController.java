package com.bookStoreApp.controller;

import com.bookStoreApp.dto.BookStoreDto;
import com.bookStoreApp.service.BookStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookStore")
@Api(value = "BookStore Api Dökümantasyonu.")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }


    @GetMapping
    @ApiOperation(value = "Tüm Bookları getirme metodu.")
    public ResponseEntity<List<BookStoreDto>> tumunuListele(){

        return ResponseEntity.ok(bookStoreService.getAll());
    }

    @PostMapping
    @ApiOperation(value = "Yeni Book metodu.")
    public ResponseEntity<BookStoreDto> kaydet(@RequestBody BookStoreDto bookStoreDto){
        return ResponseEntity.ok(bookStoreService.save(bookStoreDto));
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
