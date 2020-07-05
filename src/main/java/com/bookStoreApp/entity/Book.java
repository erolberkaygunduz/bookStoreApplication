package com.bookStoreApp.entity;

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
public class Book implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kitap")
    @GeneratedValue(generator = "seq_kitap",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String bookName;

    @Column
    private double price;

    @Column
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_category_id")
    private List<Category> kategori;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookStore_id")
    private List<BookStore> stores;
}
