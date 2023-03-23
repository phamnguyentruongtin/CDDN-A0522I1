package com.example.book_borrow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    @NotEmpty
    private String bookName;
    @NotEmpty
    private String  category;
    @Min(0)
    private Double priceBook;
    @Max(1)
    private Integer amountOfBook;
    private Integer code;
    @ManyToOne()
    @JoinColumn
    private Client client;

}
