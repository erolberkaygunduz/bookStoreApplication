package com.bookStoreApp.controller;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.entity.Book;
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

    @GetMapping
    @ApiOperation(value = "Tüm Bookları getirme metodu.")
    public ResponseEntity<List<BookDto>> tumunuListele(){

        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Id ile Bookları getirme metodu.")
    public ResponseEntity<BookDto> idIleGetir(@PathVariable("id") int id){
    BookDto bookDto = bookService.getById(id);
        return ResponseEntity.ok(bookService.getById(id));
    }


    @PostMapping
    @ApiOperation(value = "Yeni Book metodu.")
    public ResponseEntity<BookDto> kaydet(@RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.save(bookDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity guncelle(@PathVariable(value = "id",required = true) int id, @RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookService.update(id,bookDto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id",required = true) int id){
        return ResponseEntity.ok(bookService.delete(id));
    }



}
