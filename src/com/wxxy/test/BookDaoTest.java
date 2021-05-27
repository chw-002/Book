package com.wxxy.test;

import com.wxxy.bean.Book;
import com.wxxy.dao.BookDao;
import com.wxxy.dao.imp.BookDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"java核心技术","不知道",new BigDecimal(100),100,100,null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(1,"mysql必知必会","张三",new BigDecimal(80),200,200,null));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(1));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(3));
    }

//    @Test
//    public void queryPageTotalCount() {
//        System.out.println(bookDao.queryPageTotalCount());
//    }
//
//    @Test
//    public void queryPageItems() {
//        for (Book book : bookDao.queryPageItems(1, 4)) {
//            System.out.println(book);
//        }
//    }
}