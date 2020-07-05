package com.bookStoreApp.service.impl;


import com.bookStoreApp.dto.CategoryDto;
import com.bookStoreApp.entity.Category;
import com.bookStoreApp.repo.CategoryRepository;
import com.bookStoreApp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImlp implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setKategoriAdi(categoryDto.getKategoriAdi());
        category.setBook(categoryDto.getBook());
        final Category categoryDb = categoryRepository.save(category);
        categoryDto.setId(categoryDb.getId() );
        return categoryDto ;
    }

    @Override
    public Boolean delete(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public CategoryDto update(int id, CategoryDto categoryDto) {
        Category category = new Category();
        category.setKategoriAdi(categoryDto.getKategoriAdi());
        category.setBook(categoryDto.getBook());
        final Category categoryDb = categoryRepository.save(category);
        categoryDto.setId(categoryDb.getId() );
        return categoryDto ;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categories.forEach(it ->{
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(it.getId());
            categoryDto.setKategoriAdi(it.getKategoriAdi());
            categoryDto.setBook(it.getBook());
            categoryDtos.add(categoryDto);
        });
        return categoryDtos;
    }

    @Override
    public CategoryDto getById(int id) {
        return null;
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        return null;
    }
}
