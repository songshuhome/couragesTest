package cn.teacher.factory;

import cn.teacher.dao.IMark;
import cn.teacher.sevice.IStudentAbsent;
import cn.teacher.sevice.IStudentIn;
import cn.teacher.sevice.IfindAllStudent;
import cn.teacher.sevice.Impl.AbsentStudent;
import cn.teacher.sevice.Impl.Mark;
import cn.teacher.sevice.Impl.findAllStudentImpl;

public class ServiceMarkStudent {
    public static IfindAllStudent getInstanceStudnet(){
        return new findAllStudentImpl();
    }
    public static IMark getMarkinstance(){
        return new Mark();
    }
    public static IStudentAbsent getAbsent(){
        return new Mark();
    }
    public static IStudentIn getInstanceAbsent(){
        return new AbsentStudent();
    }
}
