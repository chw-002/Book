package com.wxxy.dao;

import com.wxxy.bean.Book;

import java.util.List;

public interface PageDao {
    /**
     * 查询总记录数
     * @return
     */
    int queryPageTotalCount();


    /**
     * 查询当前页数据
     * @return
     */
    List<Book> queryPageItems(int begin, int pageSize);


    /**
     * 按价格区间查询总记录数
     * @param min
     * @param max
     * @return
     */
    int queryPageTotalCountByPrice(int min,int max);


    /**
     * 根据价格区间查询当前页数据
     * @param min
     * @param max
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryPageItemsByPrice(int min,int max,int begin ,int pageSize);
}
