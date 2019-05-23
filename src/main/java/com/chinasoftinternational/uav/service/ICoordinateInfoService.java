package com.chinasoftinternational.uav.service;

import com.chinasoftinternational.uav.bean.CoordinateInfo;

/**
 * @ClassName ICoordinateInfoDao.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 16:08
 */
public interface ICoordinateInfoService {

    /**
     * 插入坐标
     * @param coordinateInfo
     * @return
     */
    public void insertCoordinateInfo(CoordinateInfo coordinateInfo) throws RuntimeException;


}
