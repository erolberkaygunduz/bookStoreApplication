package com.bookStoreApp.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
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
    private int id;

    @Column
    private String  kitapciAdi;

    @Column
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String sehir;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_bookStore_id")
    private List<Book> book;
}
