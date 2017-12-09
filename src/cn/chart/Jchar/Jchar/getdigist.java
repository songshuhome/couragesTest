package cn.chart.Jchar.Jchar;

import javafx.scene.chart.CategoryAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import util.AbstractDAOImpl;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getdigist extends AbstractDAOImpl{
    public getdigist(Connection conn) {
        super(conn);
    }
    public  String getGrade(String aid)throws SQLException{
        String grade="";
        String sql="SELECT grade FROM admins WHERE aid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,aid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            grade=rs.getString(1);
        }
        return grade;
    }
    public  CategoryDataset createDataset(String aid) throws SQLException //创建柱状图数据集
    {
        String grade="";
        try {
           grade=getGrade(aid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String grade1=grade.substring(0,6);
        String grade2=grade.substring(9,17);
        String grade3=grade.substring(18,grade.length());

        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        try {
            dataset.setValue(getStudentAbsent(grade1),"a",grade1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataset.setValue(getStudentAbsent(grade2),"b",grade2);
        dataset.setValue(getStudentAbsent(grade3),"c",grade3);
        return dataset;
    }
    public  JFreeChart createChart(String aid) //用数据集创建一个图表
    {
        StandardChartTheme standardChartTheme=new StandardChartTheme("/assets/img");
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));//创建主体样式
        standardChartTheme.setRegularFont(new Font("微软雅黑",Font.PLAIN,15));
        standardChartTheme.setLargeFont(new Font("微软雅黑",Font.PLAIN,15));
        ChartFactory.setChartTheme(standardChartTheme);
        JFreeChart chart= null;
        try {
            chart = ChartFactory.createBarChart3D(
                    "学生课检统计",
                    "班级",
                    "人数",
                    createDataset(aid),
                    PlotOrientation.VERTICAL,
                    false,
                    false,
                    false


            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chart;



    }
    public  int getStudentAbsent(String grade)throws SQLException{
        int number=0;
        String sql="SELECT name FRAME absent WHERE grade=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,grade);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            number++;
        }
        return number;
    }

}
