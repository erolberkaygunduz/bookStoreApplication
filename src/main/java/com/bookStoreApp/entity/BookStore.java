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
public class BookStore implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kitapci")
    @GeneratedValue(generator = "seq_kitapci",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String  kitapciAdi;

    @Column
    private String sehir;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookStore_id")
    private Book book;
}
