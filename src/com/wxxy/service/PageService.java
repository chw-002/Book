package com.wxxy.service;

import com.wxxy.bean.Book;
import com.wxxy.bean.Page;

public interface PageService {
    /**
     * 根据当前页码和页面大小分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> page(int pageNo,int pageSize);


    /**
     * 根据价格区间分页
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);
}
