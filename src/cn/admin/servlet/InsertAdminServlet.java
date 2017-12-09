package cn.admin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import cn.admin.facory.FactoryService;
import cn.student.vo.*;
@WebServlet(name="insertAdminServlet",urlPatterns = "/pages/back/InsertAdminServlet/*")
public class InsertAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/pages/error.jsp";//定义错误页面
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);
        if (status != null) {
            if("creat".equals(status)){
                path=this.InsertAdmin(req);
            }
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    private String InsertAdmin(HttpServletRequest req) {
        String msg="";//提示语句
        String url="";//表示跳转路径
        String mid=req.getParameter("mid");
        String passwordm=(new util.MD5Code().getMD5ofStr((req.getParameter("passwordm")+mid)));
        String name=req.getParameter("name");
         String grade=req.getParameter("grade");
         admin vo=new admin();
         vo.setAid(mid);
         vo.setName(name);
         vo.setGrade(grade);
         vo.setPassword(passwordm);
        try {
            if(FactoryService.ServiceInsertInstance().InsertAdmin(vo)){
                msg="添加成功！";
                url="/pages/back/admin/adminInsert.jsp";
            }else {
                msg="添加失败，请重新输入数据";
                url="/pages/back/admin/adminInsert.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";
     }
}
