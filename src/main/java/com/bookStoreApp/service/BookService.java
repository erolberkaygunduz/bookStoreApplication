package com.bookStoreApp.service;

import com.bookStoreApp.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto save(BookDto bookDto);

    void delete(Long id);

    List<BookDto> getAll();

    Page<BookDto> getAll(Pageable pageable);
}
