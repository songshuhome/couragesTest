package cn.login.factory;

import cn.login.service.DAOServiceImpl;
import cn.login.service.IADOService;

public class SeriviceFactory {
    public static IADOService getDAOSeriviceImpl(){return new DAOServiceImpl();}
}
