package com.bookStoreApp.service.impl;

import com.bookStoreApp.dto.BookDto;
import com.bookStoreApp.entity.Book;
import com.bookStoreApp.repo.BookRepository;
import com.bookStoreApp.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookDto save(BookDto bookDto) {

   //     Assert.isNull(bookDto.getBookName(),"Kitap adi bos birakilamaz.");
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setPrice(bookDto.getPrice());
        book.setKategori(bookDto.getCategories());
        book.setStores(bookDto.getStores());
        final Book bookDb = bookRepository.save(book);
        bookDto.setId(bookDb.getId() );
        return bookDto;
    }


    @Override
    public Boolean delete(int id) {
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public BookDto update(int id, BookDto bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setPrice(bookDto.getPrice());
        book.setKategori(bookDto.getCategories());
        book.setStores(bookDto.getStores());
        final Book bookDb = bookRepository.save(book);
        bookDto.setId(bookDb.getId() );
        return bookDto;

    }


    @Override
    public List<BookDto> getAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        books.forEach(it ->{
            BookDto bookDto = new BookDto();
            bookDto.setId(it.getId());
            bookDto.setBookName(it.getBookName());
            bookDto.setPrice(it.getPrice());
            bookDto.setCategories((it.getKategori()));
            bookDto.setStores(it.getStores());
            bookDtos.add(bookDto);
        });
        return bookDtos;
    }

    @Override
    public BookDto getById(int id) {
        Book books = bookRepository.findById(id).orElse(null);
        BookDto bookDto = new BookDto();
        bookDto.setId(books.getId());
        bookDto.setBookName(books.getBookName());
        bookDto.setPrice(books.getPrice());
        bookDto.setCategories((books.getKategori()));
        bookDto.setStores(books.getStores());
        return bookDto;
    }

    @Override
    public Page<BookDto> getAll(Pageable pageable) {
        return null;
    }
}
