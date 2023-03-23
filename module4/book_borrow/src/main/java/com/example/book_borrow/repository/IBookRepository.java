package com.example.book_borrow.repository;

import com.example.book_borrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from book",nativeQuery = true)
    Page<Book> listAllBook(PageRequest page);
    @Query(value = "select * from book where amount_of_book = 1",nativeQuery = true)
    Page<Book> listAllReadyForBorrows(PageRequest pageRequest);
    @Query(value = "select * from book where amount_of_book = 0",nativeQuery = true)
    Page<Book> listAllBookIsBorrows(PageRequest pageRequest);
    Book findBookBybookName(String bookName);

}
