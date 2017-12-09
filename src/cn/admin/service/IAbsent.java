package cn.admin.service;

import java.util.Map;

public interface IAbsent {
//    /**
//     * 定义分页接口类
//     * @param column
//     * @param keyWord
//     * @param currentPage
//     * @param lineSize
//     * @return
//     * @throws Exception
//     */
//    public Map<String,Object> listBySplit(String column, String keyWord, int currentPage, int lineSize)throws Exception;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    public Map<String,Object> findallStuentsAdmin(String sid)throws Exception;
}
