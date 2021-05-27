package com.wxxy.web;

import com.wxxy.bean.Book;
import com.wxxy.bean.Page;
import com.wxxy.service.BookService;
import com.wxxy.service.PageService;
import com.wxxy.service.impl.BookServiceImpl;
import com.wxxy.service.impl.PageServiceImpl;
import com.wxxy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.wxxy.bean.Page.PAGE_SIZE;

public class BookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();
    PageService pageService = new PageServiceImpl();

    //显示图书列表
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询
        List<Book> books = bookService.queryBooks();
        //保存到request域中
        req.setAttribute("books",books);
        //转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

    //添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //添加图书
        bookService.addBook(book);
        //获取pageNo
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //修改图书信息
        bookService.updateBook(book);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //删除图书
        bookService.deleteBookById(id);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //通过id查询图书
        Book book = bookService.queryBookById(id);
        //保存图书信息到request域中
        req.setAttribute("book",book);
        //重定向
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),PAGE_SIZE);
        //处理分页
        Page<Book> page = pageService.page(pageNo, pageSize);
        //设置url
        page.setUrl("manager/bookServlet?action=page");
        //保存分页信息到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
