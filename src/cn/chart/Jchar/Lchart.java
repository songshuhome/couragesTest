package cn.chart.Jchar;

import org.jfree.chart.servlet.ServletUtilities;
import util.dbc.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import cn.chart.Jchar.Jchar.getdigist;
@WebServlet(name="lchart",urlPatterns = "/pages/Lchart/*")
public class Lchart extends HttpServlet  {
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
                    chart(req);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        req.getRequestDispatcher("/pages/char.jsp").forward(req, resp);
    }

    private void chart(HttpServletRequest req) {
        String fileName="";
        DatabaseConnection jdbc =new DatabaseConnection();
        getdigist g=new getdigist(jdbc.getConn());
        String aid=req.getParameter("aid");
        try {
             fileName= ServletUtilities.saveChartAsJPEG(g.createChart(aid),450,300,req.getSession());
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            throw e;
        }
        System.out.println(fileName);
    }


}
