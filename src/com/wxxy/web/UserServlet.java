package com.wxxy.web;

import com.google.gson.Gson;
import com.wxxy.bean.User;
import com.wxxy.service.UserService;
import com.wxxy.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();
    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userService.login(username,password) ==null){
            req.setAttribute("msg","用户名或密码错误");
            System.out.println("用户名或密码错误");
            //把用户名保存到session中
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            System.out.println("登录成功");
            req.getSession().setAttribute("username",username);
            //获取用户，保存到session中
            User user = userService.login(username, password);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }


    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session
        req.getSession().invalidate();
        //重定向
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");


        //1、配置xml文件  在表单中引入验证码图片
        //2、获取session域中的验证码
        String  sessionCode = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //3、删除session域中的验证码
        req.getSession().removeAttribute(sessionCode);
        //判断验证码是否正确
        if(sessionCode != null && sessionCode.equalsIgnoreCase(code)){
            // 正确  判断用户名是否可用
            if(userService.existUsername(username)){
                //不可用
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                // 跳转到注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //可用 保存到数据库 跳转到注册成功页面
                User user =  new User(null,username,password,email);
                userService.regist(user);
                req.getSession().setAttribute("username",username);
                req.getSession().setAttribute("user",user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                System.out.println("注册成功");
            }


        }else {
            //不正确 跳转到注册页面
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            System.out.println("验证码错误");
        }
    }


    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        //判断是否存在
        boolean existUsername = userService.existUsername(username);
        //把返回结果封装成Map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",existUsername);

        //把Json对象转换成字符串对象
        Gson gson = new Gson();
        String jsonString = gson.toJson(resultMap);

        resp.getWriter().write(jsonString);
    }
}
