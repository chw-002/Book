package com.wxxy.dao.imp;

import com.wxxy.bean.Book;
import com.wxxy.dao.BookDao;
import com.wxxy.dao.PageDao;
import org.junit.Test;

import java.util.List;

public class PageDaoImpl extends BaseDao implements PageDao {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public int queryPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryPageItems(int begin,int pageSize) {
        String sql = "select * from t_book limit ?,?";
        return queryForList(sql,Book.class,begin,pageSize);
    }

    @Override
    public List<Book> queryPageItemsByPrice(int min, int max,int begin,int pageSize) {
        String sql = "select * from t_book where price between ? and ? limit ? , ?";
        return queryForList(sql,Book.class,min,max,begin,pageSize);
    }

    @Override
    public int queryPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }
}
