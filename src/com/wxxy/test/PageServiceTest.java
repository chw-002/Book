package com.wxxy.test;


import com.wxxy.bean.Book;
import com.wxxy.bean.Page;
import com.wxxy.service.PageService;
import com.wxxy.service.impl.PageServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class PageServiceTest {

    PageService pageService = new PageServiceImpl();
    @Test
    public void page() {
        Page<Book> page = pageService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = pageService.pageByPrice(1, 4, 40, 80);
        System.out.println(page);
    }
}