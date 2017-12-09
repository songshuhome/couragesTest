package cn.teacher.servlet;

import cn.teacher.factory.ServiceMarkStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name="absent",urlPatterns = "/pages/back/AbsentServlet/*")
public class AbsentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/pages/errors.jsp";//定义错误页面
        String status=req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("grade".equals(status)){
                path=this.getGrade(req);
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }



    private String getGrade(HttpServletRequest req) {
        String stept= req.getParameter("stept");
        String lesson=req.getParameter("lesson");
        Map<String ,Object> map=null;
        try {
            map= ServiceMarkStudent.getInstanceAbsent().getGrade(stept,lesson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("allGrade",map.get("allGrade"));
        return "/pages/back/teacher/allGrade.jsp";
    }
}
