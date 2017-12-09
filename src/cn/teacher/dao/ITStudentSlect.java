package cn.teacher.dao;

import cn.student.vo.Grade;

import java.sql.SQLException;
import java.util.List;
import cn.student.vo.absent;
public interface ITStudentSlect {
    /**
     * 查询所有学生平时分
     * @return 成功返回集合
     * @throws SQLException
     */
    public List<Grade> findAllGrade(String stept,String lesson)throws SQLException;

}
