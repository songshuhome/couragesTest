package cn.login.servlet;

import cn.login.factory.SeriviceFactory;
import util.dbc.DatabaseConnection;
import util.loginName.FactoryName;
import util.validate.*;
import java.util.*;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import cn.student.vo.admin;

@WebServlet(name="dAOServlet",urlPatterns = "/pages/back/DAOServlet/*")
public class DAOServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/pages/error.jsp";//定义错误页面
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            if ("login".equals(status)) {
                try {
                    path = this.login(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if("logout".equals(status)){
                path=this.logout(req);
            }
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    private String logout(HttpServletRequest req) {
         req.getSession().invalidate();//初始化操作
        req.setAttribute("msg","您已退出系统，请重新登录");
        req.setAttribute("url","/login.jsp");
        return "/pages/forward.jsp";
    }

    private String login(HttpServletRequest req) throws SQLException {
        String msg = "";//表示提示信息
        String url = "";//表示跳转路径
        //取得从页面传来的数据
        String aid = req.getParameter("aid");
        String ip=req.getRemoteAddr();
        Date lastdate= new Date(new java.util.Date().getTime());
        String password = (new util.MD5Code().getMD5ofStr(req.getParameter("password")+aid));
        String name=getName(req);
        if(Validate.validateEmpty(aid)&&Validate.validateEmpty(password)){

            if(SeriviceFactory.getDAOSeriviceImpl().alogin(aid,password)){
                  int flag=0;
                 try {
                      flag=SeriviceFactory.getDAOSeriviceImpl().theSuperAdmin(aid);
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 req.getSession().setAttribute("aid",aid);
                 req.getSession().setAttribute("flag",flag);
                 req.getSession().setAttribute("lastdate",lastdate);
                 req.getSession().setAttribute("password",password);
                 req.getSession().setAttribute("name",name);
                 msg = "登录成功";
                 url = "/pages/back/admin/adminlogin.jsp";

             }else if(SeriviceFactory.getDAOSeriviceImpl().slogin(aid,password)){
                 req.getSession().setAttribute("aid",aid);
                 req.getSession().setAttribute("password",password);
                 req.getSession().setAttribute("lastdate",lastdate);
                 req.getSession().setAttribute("name",name);
                 msg = "登录成功";
                 url = "/pages/back/student/studentLogin.jsp";
             }else if(SeriviceFactory.getDAOSeriviceImpl().tlogin(aid,password)){
                 req.getSession().setAttribute("aid",aid);
                 req.getSession().setAttribute("password",password);
                 req.getSession().setAttribute("lastdate",lastdate);
                 req.getSession().setAttribute("name",name);
                 msg = "登录成功";
                 url = "/pages/back/teacher/teacherLogin.jsp";

             }else {
                 msg = "登录失败，错误的ID或密码";
                 url = "/login.jsp";

             }

        }else {
            msg = "数据不能为空";
            url = "/login.jsp";
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
    private String getName(HttpServletRequest req){
        String name=null;
        String aid=req.getParameter("aid");
        DatabaseConnection jdbc=new DatabaseConnection();
        try {
            name= FactoryName.getNameGetInstance(jdbc.getConn()).forName(aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

}