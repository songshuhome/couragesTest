package cn.admin.service.Impl;

import cn.admin.facory.FactoryAdmin;
import cn.admin.service.IAdminService;
import cn.student.vo.admin;
import util.dbc.DatabaseConnection;

import java.sql.SQLException;

public class AdminServiceImpl implements IAdminService {
    DatabaseConnection jdbc=new DatabaseConnection();
    @Override
    public boolean InsertAdmin(admin vo) throws Exception {
        try{
        return FactoryAdmin.getAdminInstance(this.jdbc.getConn()).doCreate(vo);
    }catch (Exception e){
        throw e;
        }finally {
        this.jdbc.close();
        }
    }

    }


