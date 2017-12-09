package cn.student.servlet;

import cn.admin.facory.FactoryService;
import cn.student.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

import cn.student.factory.StudentFactory;
import cn.student.vo.student;
import util.validate.Validate;

@WebServlet(name="studentLeave",urlPatterns = "/pages/back/StudentLeave/*")
public class StudentLeave extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path="/pages/errors.jsp";//定义错误页面
        String status=req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("leave".equals(status)){
                try {
                    path=this.updateLeave(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if("sign".equals(status)){
                path=this.updateSign(req);
            }else if("courage".equals(status)){
                path=this.getCourage(req);
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String getCourage(HttpServletRequest req) {
        String sid= (String) req.getSession().getAttribute("aid");
        Map<String ,Object> map=null;
        try {
            map= ServiceFactory.getStudentCourage().getAllCourages(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("allCourages",map.get("allCourages"));
        return "/pages/back/student/weekCourage.jsp";
    }

    private String updateSign(HttpServletRequest req) {
        String msg="";//提示
        String url="";//表示跳转路径
        String a=req.getParameter("lng");
        String b=req.getParameter("lat");
        boolean flag=false;
        flag=getMap(a,b);
        String sid= (String) req.getSession().getAttribute("aid");
        student vo=new student();
        vo.setSid(sid);
        Integer time=presentTime();
        if(allow(time)){
            try {
                if(ServiceFactory.getStudentServiceLeaveInstance().updateSignStudent(vo)&&false){
                    msg="签到成功";
                    url="/pages/back/student/studentleave.jsp";
                }else{
                    msg="签到不成功，请重新登录签到";
                    url="/login.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else{
            msg="签到时间未到，请选者正确时间登录！";
            url="/pages/back/student/studentleave.jsp";
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";

    }

    private boolean getMap(String a,String b) {
        boolean flag=false;
        double f= Double.parseDouble(a);
        double g=Double.parseDouble(b);
        if((f>=115.89352755-0.1&&f<=115.89352755+0.1)&&(g>=28.689578-0.1&&g<=28.689578+0.1)){
             flag=true;
        }else{
            flag=false;
        }
        return flag;
    }

    private String updateLeave(HttpServletRequest req) {
        String msg="";//提示
        String url="";//表示跳转路径
        String sid= (String) req.getSession().getAttribute("aid");
        student vo=new student();
        vo.setSid(sid);
        Integer time=presentTime();
        if(allow(time)){
            try {
                if(ServiceFactory.getStudentServiceLeaveInstance().updateLeaveStudent(vo)){
                    msg="请假成功！";
                    url="/pages/back/student/studentleave.jsp";
                }else{
                    msg="请假不成功，请重新登录请假";
                    url="/login.jsp";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else{
            msg="请假时间未到，请选者正确时间登录！";
            url="/pages/back/student/studentleave.jsp";
        }
        req.setAttribute("msg",msg);
        req.setAttribute("url",url);
        return "/pages/forward.jsp";

    }
    private Integer presentTime(){
        Calendar cal=Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int minnue=cal.get(Calendar.MINUTE);
        int time=hour*100+minnue;
        return time;

    }
   private boolean allow(Integer time){
        if((time>=750&&time<=755)||(time>=1000&&time<=1005)||(time>=1400&&time<=1405)||(time>=1600&&time<=1605)||(time>1650))
            return true;
        else return false;
   }
}

