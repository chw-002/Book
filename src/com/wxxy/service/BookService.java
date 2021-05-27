package com.wxxy.service;

import com.wxxy.bean.Book;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     * @param book
     */
    void addBook(Book book);

    /**
     * 修改图信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 通过id删除图书
     * @param id
     */
    void deleteBookById(Integer id);

    /**
     * 通过id 查询图书信息
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询全部图书信息
     * @return
     */
    List<Book> queryBooks();

}
