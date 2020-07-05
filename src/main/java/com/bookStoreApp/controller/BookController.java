package com.bookStoreApp.controller;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "Book Api Dökümantasyonu.")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ApiOperation(value = "Yeni Book metodu.")
    public ResponseEntity<BookDto> kaydet(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.save(bookDto));
    }

    @GetMapping
    @ApiOperation(value = "Tüm Bookları getirme metodu.")
    public ResponseEntity<List<BookDto>> tumunuListele(){

        return ResponseEntity.ok(bookService.getAll());
    }


}
