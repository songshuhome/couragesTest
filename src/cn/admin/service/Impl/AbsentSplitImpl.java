package cn.admin.service.Impl;

import cn.admin.facory.FactoryAdmin;
import cn.admin.service.IAbsent;
import util.dbc.DatabaseConnection;

import java.util.HashMap;
import java.util.Map;

public class AbsentSplitImpl implements IAbsent {
    DatabaseConnection dbc=new DatabaseConnection();
//    @Override
//    public Map<String, Object> listBySplit(String column, String keyWord, int currentPage, int lineSize) throws Exception {
//        try{
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("allBooks" , FactoryAdmin.getAbsentInstance(this.dbc.getConn()).findAllById(column,keyWord,currentPage,lineSize));
//            map.put("allCounts",FactoryAdmin.getAbsentInstance(this.dbc.getConn()).getAllCount(column,keyWord));
//            return map;
//        }catch (Exception e){
//            throw e;
//        }finally {
//            this.dbc.close();
//        }
//    }

    @Override
    public Map<String, Object> findallStuentsAdmin(String sid) throws Exception {
        try {
           Map<String,Object> map=new HashMap<String,Object>();
           map.put("allBooks", FactoryAdmin.getAbsentInstance(this.dbc.getConn()).getAbsentStudents(sid));
           return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

}
