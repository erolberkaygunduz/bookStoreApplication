package com.bookStoreApp.service;


import com.bookStoreApp.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    Boolean delete(int id);

    CategoryDto update(int id, CategoryDto categoryDto);

    List<CategoryDto> getAll();

    CategoryDto getById(int id);

    Page<CategoryDto> getAll(Pageable pageable);
}
