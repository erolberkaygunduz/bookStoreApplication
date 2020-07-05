package com.bookStoreApp.dto;

import com.bookStoreApp.entity.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Category Nesnesi")
public class CategoryDto {
    @ApiModelProperty(value = "Category nesnesi id alanı.")
    private int id;

    @ApiModelProperty(value = "Category nesnesi kategoriAdi alanı.")
    private String  kategoriAdi;


    @ApiModelProperty(value = "BookStore nesnesi books alanı.")
    private List<Book> book;
}
