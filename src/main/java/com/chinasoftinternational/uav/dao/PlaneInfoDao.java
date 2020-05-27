package com.chinasoftinternational.uav.dao;

import com.chinasoftinternational.uav.bean.PlaneInfo;

/**
 * @ClassName IPlaneInfoDao.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 20:10
 */
public interface PlaneInfoDao {

    /**
     * 根据飞机名称获取飞机信息
     * @param planeName
     * @return
     */
    public PlaneInfo findPlaneInfoByPlaneName(String planeName) throws RuntimeException;

    /**
     * 添加/修改飞机记录
     * @param planeInfo
     * @return
     */
    public void insertOrUpdatePlaneInfo(PlaneInfo planeInfo) throws RuntimeException;
}
