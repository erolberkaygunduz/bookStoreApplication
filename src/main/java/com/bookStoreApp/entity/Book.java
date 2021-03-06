package com.bookStoreApp.entity;

import com.bookStoreApp.dto.BookDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Book extends BookDto implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kitap")
    @GeneratedValue(generator = "seq_kitap",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String bookName;

    @Column
    private double price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(cascade = CascadeType.ALL)
    private List<BookStore> stores;


}
