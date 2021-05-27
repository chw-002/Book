package com.wxxy.dao;

import com.wxxy.bean.Book;
import com.wxxy.bean.Page;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return  返回-1 表示添加失败，其他值表示添加记录条数
     */
    int addBook(Book book);

    /**
     * 根据book id属性修改图书信息
     * @param book
     * @return 返回-1 表示修改失败 其他表示成功
     */
    int updateBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return 返回-1 表示删除失败，其他值表示成功
     */
    int deleteBookById(Integer id);

    /**
     * 查询所有的记录
     * @return
     */
    List<Book> queryBooks();

    /**
     * 根据id查询一条图书信息
     * @param id
     * @return
     */
    Book queryBookById(Integer id);
}
