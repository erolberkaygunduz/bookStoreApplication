package com.bookStoreApp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kitap_kategori")
    @GeneratedValue(generator = "seq_kitap_kategori",strategy =GenerationType.SEQUENCE)
    private int id;

    @Column
    private String kategoriAdi;


    @OneToMany
    @JoinColumn(name = "book_category_id")
    private List<Book> book;


}
