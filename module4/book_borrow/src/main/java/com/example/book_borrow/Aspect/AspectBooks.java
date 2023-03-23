package com.example.book_borrow.Aspect;

import com.example.book_borrow.model.Book;
import com.example.book_borrow.repository.IBookRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBooks {
    @Autowired
    private IBookRepository iBookRepository;


    @After(value = "execution(* com.example.book_borrow.controller.BorrowsController.doBorrowsBook(..)) && args(book,..))")
    public void afterBookBorrows(Book book) {
        Book temp = iBookRepository.findById(book.getBookId()).orElseThrow(() -> new RuntimeException(""));
        Integer amountBook = temp.getAmountOfBook() - 1;
        temp.setAmountOfBook(amountBook);
        iBookRepository.save(temp);
    }

    @After(value = "execution(* com.example.book_borrow.controller.BorrowsController.doReturnBook(..)) && args(book,..))")
    public void afterBookReturn(Book book) {
        Book temp = iBookRepository.findById(book.getBookId()).orElseThrow(() -> new RuntimeException(""));
        Integer amountBook = temp.getAmountOfBook() + 1;
        temp.setAmountOfBook(amountBook);
        iBookRepository.save(temp);
    }
}
