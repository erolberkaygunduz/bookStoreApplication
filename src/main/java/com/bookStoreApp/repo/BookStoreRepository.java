package com.bookStoreApp.repo;

import com.bookStoreApp.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {
}
