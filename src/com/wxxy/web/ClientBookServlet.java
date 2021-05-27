package com.wxxy.web;

import com.wxxy.bean.Book;
import com.wxxy.bean.Page;
import com.wxxy.service.PageService;
import com.wxxy.service.impl.PageServiceImpl;
import com.wxxy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.wxxy.bean.Page.PAGE_SIZE;

public class ClientBookServlet extends BaseServlet{
    PageService pageService = new PageServiceImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), PAGE_SIZE);
        //处理分页
        Page<Book> page = pageService.page(pageNo, pageSize);
        //设置url
        page.setUrl("client/BookServlet?action=page");
        //把分页对象保存到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void pagePrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //处理分页
        Page<Book> page = pageService.pageByPrice(pageNo, pageSize,min,max);

        //获取url
        StringBuilder builder = new StringBuilder("client/BookServlet?action=pagePrice");
        //按价格查询后上一页，下一页需要传递min max参数
        if(req.getParameter("min") != null){
            builder.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null){
            builder.append("&max=").append(req.getParameter("max"));
        }
        //设置url
        page.setUrl(builder.toString());
        //把分页对象保存到request域中
        req.setAttribute("page",page);
        //请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
