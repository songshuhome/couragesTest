package cn.student.factory;

import cn.student.dao.Icourages;
import cn.student.service.IStudentLSService;
import cn.student.service.IStudentSerive;
import cn.student.service.IStudentsCourage;
import cn.student.service.Impl.StudentLSService;
import cn.student.service.Impl.StudentService;
import cn.student.service.Impl.StudentsCourage;

public class ServiceFactory {
    public static IStudentSerive getStudentServiceInstance(){
        return new StudentService();
    }
    public  static  IStudentLSService getStudentServiceLeaveInstance(){
        return  new StudentLSService();
    }
    public static IStudentsCourage getStudentCourage(){return new StudentsCourage();}
}
