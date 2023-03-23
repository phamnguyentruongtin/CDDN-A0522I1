package com.example.book_borrow.service;

import com.example.book_borrow.model.Book;
import com.example.book_borrow.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Page<Book> listAllBook(PageRequest pageRequest) {
        Page<Book> page = iBookRepository.findAll(pageRequest);
        return page;
    }

    @Override
    public Page<Book> listAllReadyForBorrows(PageRequest pageRequest) {
        Page<Book> page = iBookRepository.listAllReadyForBorrows(pageRequest);
        return page;
    }

    @Override
    public Page<Book> listAllBookIsBorrows(PageRequest pageRequest) {
        Page<Book> page = iBookRepository.listAllBookIsBorrows(pageRequest);
        return page;
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        iBookRepository.delete(book);
    }

    @Override
    public Book findByIdBook(Integer idBook) {
       Book book = iBookRepository.findById(idBook).get();
        return book;
    }

    @Override
    public void borrowsBook(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setClient(null);
        iBookRepository.save(book);
    }

    @Override
    public Book findBookByName(String name) {
        Book book = iBookRepository.findBookBybookName(name);
        return book;
    }
}
