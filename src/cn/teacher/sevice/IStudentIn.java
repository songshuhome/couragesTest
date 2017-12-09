package cn.teacher.sevice;

import cn.student.vo.*;

import java.util.Map;

public interface IStudentIn {
    /**
     * 查询学生平时成绩
     * @return 成功返回学生所有成绩
     * @throws Exception
     */
   public Map<String,Object> getGrade(String stept,String tid)throws Exception;


}
