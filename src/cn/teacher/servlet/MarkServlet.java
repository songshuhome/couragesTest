package cn.teacher.servlet;

import cn.teacher.factory.ServiceMarkStudent;
import util.validate.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="markServlet",urlPatterns = "/pages/back/MarkServlet/*")
public class MarkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/pages/errors.jsp";//定义错误页面
        String status=req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("decrease".equals(status)){
                path=this.decrease(req);
            }else if("increase".equals(status)){
                path=this.increase(req);
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String increase(HttpServletRequest req) {
        String msg="";//扣分提示
        String url="";//跳转路径
       String sid=req.getParameter("sid");
       String tid= (String) req.getSession().getAttribute("aid");
       int    number= Integer.parseInt(req.getParameter("grade"));
        if(Validate.validateEmpty(sid)){
            try {
                if(ServiceMarkStudent.getMarkinstance().increaseGrade(sid,number,tid)){
                    msg="加分成功";
                    url="/pages/back/teacher/studentmark.jsp";
                }else {
                    msg="加分失败";
                    url="/pages/back/teacher/studentmark.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            msg="数据为空，请重新输入";
            url="/pages/back/teacher/studentmark.jsp";
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";
    }


    private String decrease(HttpServletRequest req) {
         String msg="";//扣分提示
         String url="";//跳转路径
         String tid= (String) req.getSession().getAttribute("aid");
         int number= Integer.parseInt(req.getParameter("mark"));
         if(Validate.validateEmpty(tid)){
             try {
                 if(ServiceMarkStudent.getMarkinstance().decreaseMark(tid,number)){
                      msg="扣分成功";
                     url="/pages/back/teacher/studentmark.jsp";
                 }else {
                     msg="扣分失败";
                     url="/pages/back/teacher/studentmark.jsp";
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }else{
             msg="数据为空，请重新输入";
             url="/pages/back/teacher/stuentmark.jsp";
         }
        req.setAttribute("msg",msg);
         req.setAttribute("url",url);
         return "/pages/forward.jsp";
    }
}
