package com.wxxy.test;

import com.wxxy.bean.Book;
import com.wxxy.dao.BookDao;
import com.wxxy.dao.PageDao;
import com.wxxy.dao.imp.BookDaoImpl;
import com.wxxy.dao.imp.PageDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageDaoTest {

    PageDao pageDao = new PageDaoImpl();
    @Test
    public void queryPageTotalCount() {
        System.out.println(pageDao.queryPageTotalCount());
    }

    @Test
    public void queryPageItems() {
        for (Book book : pageDao.queryPageItems(1, 4)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryPageTotalCountByPrice() {
        System.out.println(pageDao.queryPageTotalCountByPrice(40,80));
    }

    @Test
    public void queryPageItemsByPrice() {
        for (Book book : pageDao.queryPageItemsByPrice(40, 80, 0, 4)) {
            System.out.println(book);
        }
    }
}