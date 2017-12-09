package util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "dAOServlet",urlPatterns = {"/pages/back/index.jsp","/pages/back/student/studentLogin.jsp",
        "/pages/back/student/studentleave.jsp","/pages/back/student/courage_list.jsp","/pages/back/teacher/teachersign.jsp",
        "/pages/back/teacher/teacherLogin.jsp","/pages/back/teacher/allGrade.jsp", "/pages/back/teacher/studentmark.jsp",
        "/pages/back/teacher/teachergrade.jsp","/pages/back/teacher/teachersign.jsp","/pages/back/admin/absent_split.jsp",
        "/pages/back/admin/adminInset.jsp","/pages/back/admin/adminlogin.jsp","/pages/back/admin/gradeAbsent.jsp","/pages/bcak/admin/GradeIn.jsp",
        "/pages/back/admin/students_char.jsp"})
public class AdminLoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session=request.getSession();//取得session对象
        if(session.getAttribute("aid")!=null){//表示内容存在
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.setAttribute("msg","你还没登录，请登录后操作！");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
