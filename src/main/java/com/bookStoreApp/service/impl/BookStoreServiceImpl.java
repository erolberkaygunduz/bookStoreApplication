package com.bookStoreApp.service.impl;


import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.dto.BookStoreDto;
import com.bookStoreApp.entity.Book;
import com.bookStoreApp.entity.BookStore;
import com.bookStoreApp.repo.BookRepository;
import com.bookStoreApp.repo.BookStoreRepository;
import com.bookStoreApp.service.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;
    private final BookRepository bookRepository;


    @Override
    public BookStoreDto save(BookStoreDto bookStoreDto) {
        BookStore bookStore = new BookStore();
        bookStore.setKitapciAdi(bookStoreDto.getKitapciAdi());
        bookStore.setSehir(bookStoreDto.getSehir());
        final BookStore bookStoreDb = bookStoreRepository.save(bookStore);
        bookStoreDto.setId(bookStoreDb.getId() );
        return bookStoreDto;

    }

    @Override
    public List<BookDto> getBooksByStoreName(String storeName) {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for(int i = 0; i < books.size(); i++) {
            if (books.get(i).getStores().get(0).getKitapciAdi().equals(storeName)) {
                BookDto bookDto = new BookDto();
                bookDto.setId(books.get(i).getId());
                bookDto.setBookName(books.get(i).getBookName());
                bookDto.setPrice(books.get(i).getPrice());
                bookDto.setStores(books.get(i).getStores());
                bookDtos.add(bookDto);
            }
        }
        return bookDtos;
    }


    @Override
    public Boolean delete(int id) {
        bookStoreRepository.deleteById(id);
        return true;
    }

    @Override
    public BookStoreDto update(int id, BookStoreDto bookStoreDto) {
        BookStore bookStore = new BookStore();
        bookStore.setKitapciAdi(bookStoreDto.getKitapciAdi());
        bookStore.setSehir(bookStoreDto.getSehir());
        final BookStore bookStoreDb = bookStoreRepository.save(bookStore);
        bookStoreDto.setId(bookStoreDb.getId() );
        return bookStoreDto;
    }

    @Override
    public List<BookStoreDto> getAll() {
        List<BookStore> bookStores = bookStoreRepository.findAll();
        List<BookStoreDto> bookStoreDtos = new ArrayList<>();
        bookStores.forEach(it ->{
            BookStoreDto bookStoreDto = new BookStoreDto();
            bookStoreDto.setId(it.getId());
            bookStoreDto.setKitapciAdi(it.getKitapciAdi());
            bookStoreDto.setSehir(it.getSehir());
            bookStoreDto.setBooks((it.getBook()));
            bookStoreDtos.add(bookStoreDto);
        });
        return bookStoreDtos;
    }

    @Override
    public BookStoreDto getById(int id) {
        return null;
    }

    @Override
    public Page<BookStoreDto> getAll(Pageable pageable) {
        return null;
    }
}
