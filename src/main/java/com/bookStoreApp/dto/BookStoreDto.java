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
@ApiModel(value = "BookStore Nesnesi")
public class BookStoreDto {

    @ApiModelProperty(value = "BookStore nesnesi id alanı.")
    private int id;

    @ApiModelProperty(value = "BookStore nesnesi kitapciAdı alanı.")
    private String  kitapciAdi;

    @ApiModelProperty(value = "BookStore nesnesi sehir alanı.")
    private String sehir;

    @ApiModelProperty(value = "BookStore nesnesi books alanı.")
    private List<Book> books;
}
