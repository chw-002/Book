package com.wxxy.service.impl;

import com.wxxy.bean.Book;
import com.wxxy.bean.Page;
import com.wxxy.dao.PageDao;
import com.wxxy.dao.imp.PageDaoImpl;
import com.wxxy.service.PageService;

import java.util.List;

public class PageServiceImpl implements PageService {

    PageDao pageDao = new PageDaoImpl();
    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        // 设置每页显示的数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = pageDao.queryPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal+=1;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);
        //边界值判断  （放到setPageNo方法中）
//        if (pageNo < 1){
//            pageNo = 1;
//        }
//        if ( pageNo > pageTotal ){
//            pageNo = pageTotal;
//        }
        // 设置当前页码
        page.setPageNo(pageNo);



        // 求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Book> items = pageDao.queryPageItems(begin,pageSize);
        // 设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();


        //设置页面显示数量
        page.setPageSize(pageSize);
        //获取总记录条数
        int countByPrice = pageDao.queryPageTotalCountByPrice(min, max);
        //设置总记录数
        page.setPageTotalCount(countByPrice);
        //计算总页数
        int pageTotal = countByPrice / pageSize;

        if(countByPrice % pageSize > 0){
            pageTotal+=1;
        }
        //设置总页数
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //设置页面开始索引
        int begin = ( page.getPageNo() - 1) * pageSize;
        //获取当前页数据
        List<Book> items = pageDao.queryPageItemsByPrice(min, max, begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
