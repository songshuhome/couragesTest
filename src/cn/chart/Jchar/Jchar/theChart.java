package com.bjsxt.shopping.reports;

import java.io.*;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
/**
 * 该类用于演示最简单的柱状图生成
 * @author ThinkPad
 */
public class theChart {
    public static void main(String[] args) throws IOException {
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                "缺勤统计表", // 图表标题
                "班级", // 目录轴的显示标签
                "人数", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,  // 是否显示图例(对于简单的柱状图必须是 false)
                false, // 是否生成工具
                false  // 是否生成 URL 链接
        );

        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("c:/images/a.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart,600,400, null);
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 获取一个演示用的简单数据集对象
     *
     * @return
     */
    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(20, "缺到", "软件学院-1610");
        dataset.addValue(12, "请假", "软件学院-1610");
        dataset.addValue(30, "缺到", "软件学院-1611");
        dataset.addValue(5, "请假", "软件学院-1611");
        dataset.addValue(12, "缺到", "软件学院-1609");
        dataset.addValue(2, "请假", "软件学院-1609");
        dataset.addValue(12, "缺到", "软件学院-1612");
        dataset.addValue(5, "请假", "软件学院-1612");
        return dataset;
    }
}