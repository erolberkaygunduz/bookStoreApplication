package com.bookStoreApp.dto;

import com.bookStoreApp.entity.BookStore;
import com.bookStoreApp.entity.Category;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Book Nesnesi")
public class BookDto {
    @ApiModelProperty(value = "Book nesnesi Id alanı.")
    private int id;

    @ApiModelProperty(value = "Book nesnesi bookName alanı.")
    private String bookName;

    @ApiModelProperty(value = "Book nesnesi price alanı.")
    private double price;

    @ApiModelProperty(value = "Book nesnesi categories alanı.")
    private List<Category> categories;

    @ApiModelProperty(value = "Book nesnesi stores alanı.")
    private List<BookStore> stores;
}
