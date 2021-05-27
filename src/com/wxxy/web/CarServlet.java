package com.wxxy.web;

import com.wxxy.bean.Book;
import com.wxxy.bean.Car;
import com.wxxy.bean.CarItems;
import com.wxxy.service.BookService;
import com.wxxy.service.impl.BookServiceImpl;
import com.wxxy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    //添加商品到购物车
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //根据id获取商品信息
        Book book = bookService.queryBookById(id);
        //把商品转换成购物车商品项
        CarItems carItems = new CarItems(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //判断当前是否有购物车
        Car car = (Car) req.getSession().getAttribute("car");
        if (car == null) {
            //没有购物车，创建购物车
            car = new Car();
            //购物车对象保存到session域中
            req.getSession().setAttribute("car",car);
        }
        //添加商品到购物车
        car.addItem(carItems);
        //波最后一次添加的商品名称保存到session域中
        String lastName = carItems.getName();
        req.getSession().setAttribute("lastName",lastName);
        //请求重定向 回到原来的页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    //删除
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车
        Car car = (Car) req.getSession().getAttribute("car");
        if (car != null) {
            car.deleteItems(id);
        }
        //重定向
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        //获取购物车
        Car car = (Car) req.getSession().getAttribute("car");
        if (car != null) {
            car.updateCount(id,count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车
        Car car = (Car) req.getSession().getAttribute("car");
        if (car != null) {
            car.clear();
        }
        //重定向
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
