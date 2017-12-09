package cn.teacher.servlet;

import cn.teacher.factory.ServiceMarkStudent;
import util.validate.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="studentList",urlPatterns = "/pages/back/StudentListServlet/*")
public class StudentListServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/pages/errors.jsp";//定义错误页面
        String status=req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("list".equals(status)){
                path=this.getList(req);
            }else if("absent".equals(status)){
                path=this.absentStudent(req);
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String absentStudent(HttpServletRequest req) {
        String msg="";//表示提示
        String url="";//表示跳转路径
        String tid= (String) req.getSession().getAttribute("aid");
        if(Validate.validateEmpty(tid)){
            try {
                if(ServiceMarkStudent.getAbsent().absentStudent(tid)){
                    msg="提交成功！";
                    url="/pages/back/teacher/teachersign.jsp";
                }else{
                    msg="提交失败！";
                    url="/pages/back/teacher/teachersign.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            msg="无法获取参数请重新登录";
            url="/pages/login.jsp";
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";
    }

    private String getList(HttpServletRequest req) {
        String tid= (String) req.getSession().getAttribute("aid");
        Map<String ,Object> map=null;
        try {
            map= ServiceMarkStudent.getInstanceStudnet().findStudent(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("allstudent",map.get("allstudent"));
        return "/pages/back/teacher/teachersign.jsp";
    }
}
