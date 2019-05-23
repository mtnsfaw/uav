package com.chinasoftinternational.uav.service;

import com.chinasoftinternational.uav.bean.PlaneInfo;

/**
 * @ClassName IPlaneInfoService.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:32
 */
public interface IPlaneInfoService {

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
