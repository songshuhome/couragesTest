package cn.chart.Jchar.Jchar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class getLar {
    public static  CategoryDataset createDataset() throws SQLException //创建柱状图数据集
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.setValue(7,"请假","软件学院-1610");
        dataset.setValue(15,"缺到","软件学院-1610");
        dataset.setValue(20,"请假","软件学院-1611");
        dataset.setValue(30,"缺到","软件学院-1611");
        dataset.setValue(6,"请假","软件学院-1612");
        dataset.setValue(20,"缺到","软件学院-1612");
        return dataset;
    }
    public static JFreeChart createChart() //用数据集创建一个图表
    {
        //通过ChartFactory创建JFreeChart
        JFreeChart chart = null;
        try {
        chart = ChartFactory.createBarChart3D(
                "学生考勤统计",
                "班级",
                "学生人数",
                 createDataset(),
                PlotOrientation.VERTICAL,
                true,
                false,
                true

        );
        Image img=null;
       try{
           img= ImageIO.read(ChartUtilities.class.getResource("C:/images/a.jpg"));
       }catch (IOException e){
           e.printStackTrace();
       }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return chart;



    }
}
