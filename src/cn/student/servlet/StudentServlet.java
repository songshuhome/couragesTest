package cn.student.servlet;

import cn.student.factory.ServiceFactory;
import util.validate.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import cn.student.vo.*;
@WebServlet(name="studentServlet",urlPatterns = "/pages/back/StudentServlet/*")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/pages/errors.jsp";//定义错误页面
        String status=req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("student".equals(status)){
                try {
                    path=this.findcourage(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }



    public String findcourage(HttpServletRequest req) throws Exception {

        String sid= (String) req.getSession().getAttribute("aid");
        student vo=new student();
        vo.setSid(sid);
        if(Validate.validateEmpty(sid)) {
            req.getSession().setAttribute("allcourage", ServiceFactory.getStudentServiceInstance().list(vo));
        }
        return "/pages/back/student/courage_list.jsp";
    }


}




