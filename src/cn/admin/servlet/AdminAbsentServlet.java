package cn.admin.servlet;

import cn.admin.facory.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet(name="adminAbsentServlet",urlPatterns = "/pages/back/AdminAbsentServlet/*")
public class AdminAbsentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; // 定义错误页面
        String status = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("reg".equals(status)){
                path=this.allAbsent(req);
            }else if("Grade".equals(status)){
                path=this.allGrade(req);
            }
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }

    private String allGrade(HttpServletRequest req) {
        String stept=req.getParameter("mark");
        Map<String,Object> map=null;
        try{
            map=FactoryService.getGradeInstance().getAllGrade(stept);
        }catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("allGrade",map.get("allGrade"));
        return "/pages/back/admin/GradeIn.jsp";
    }

    private String allAbsent(HttpServletRequest req) {
        String sid= req.getParameter("mark");
        Map<String ,Object> map=null;
        try {
            map=FactoryService.getAbsentInstance().findallStuentsAdmin(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("allBooks",map.get("allBooks"));
        return "/pages/back/admin/absent_split.jsp";
    }

//    public String listSplit(HttpServletRequest request, HttpServletResponse response) {
//        int currentPage = 1;
//        int lineSize = 1;
//        try {
//            currentPage = 4;
//        }catch (Exception e){}
//        try {
//            lineSize = 8;
//        }catch (Exception e){}
//        String keyWord = request.getParameter("kw");
//        String column = request.getParameter("col");
//        if(keyWord == null){
//            keyWord = request.getParameter("mark");
//        }
//        if (column == null){
//            column = "name";
//        }
//
//        try {
//            Map<String,Object> map = FactoryService.getAbsentInstance().listBySplit(column,keyWord,currentPage,lineSize);
//            request.setAttribute("allBooks",map.get("allBooks"));
//            request.setAttribute("allRecorders",map.get("allCounts"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        request.setAttribute("url","/pages/back/admin/AdminAbsentServlet/listSplit");
//        request.setAttribute("currentPage",currentPage);
//        request.setAttribute("lineSize",lineSize);
//        return "/pages/back/admin/absent_split.jsp";
//    }

}

