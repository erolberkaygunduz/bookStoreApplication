package com.bookStoreApp.service;


import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.dto.BookStoreDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookStoreService {
    BookStoreDto save(BookStoreDto bookStoreDto);

    List<BookDto> getBooksByStoreName(String storeName);

    Boolean delete(int id);

    BookStoreDto update(int id, BookStoreDto bookStoreDto);

    List<BookStoreDto> getAll();

    BookStoreDto getById(int id);

    Page<BookStoreDto> getAll(Pageable pageable);
}
