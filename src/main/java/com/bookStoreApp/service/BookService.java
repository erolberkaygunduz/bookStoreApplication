package com.bookStoreApp.service;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto save(BookDto bookDto);

    Boolean delete(int id);

    BookDto update(int id, BookDto bookDto);

    List<BookDto> getAll();

    Book getById(int id);

    Page<BookDto> getAll(Pageable pageable);
}
