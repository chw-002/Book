package com.wxxy.test;

import com.wxxy.bean.Book;
import com.wxxy.service.BookService;
import com.wxxy.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"编译原理","老刘",new BigDecimal(100),111,222,null));
    }

    @Test
    public void updateBook(){
        bookService.updateBook(new Book(5,"java程序设计","徐华丽",new BigDecimal(122),200,390,null));
    }
    @Test
    public void deleteBookById() {
        bookService.deleteBookById(6);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(4));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }
}