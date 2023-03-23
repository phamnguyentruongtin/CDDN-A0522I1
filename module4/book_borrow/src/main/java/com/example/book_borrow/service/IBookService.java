package com.example.book_borrow.service;

import com.example.book_borrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public interface IBookService {
    Page<Book> listAllBook(PageRequest pageRequest);
    Page<Book> listAllReadyForBorrows(PageRequest pageRequest);
    Page<Book> listAllBookIsBorrows(PageRequest pageRequest);
    void save(Book book);
    void remove(Book book);
    Book findByIdBook(Integer idBook);
    void borrowsBook(Book book);
    void returnBook(Book book);
    Book findBookByName(String name);
}
