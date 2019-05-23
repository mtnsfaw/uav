package com.chinasoftinternational.uav.mapper;


import com.chinasoftinternational.uav.bean.PlaneInfo;

/**
 * @ClassName PlaneInfoMapper.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:54
 */
public interface PlaneInfoMapper {

    public PlaneInfo findPlaneInfoByPlaneName(String planeName);

    public void insertPlaneInfo(PlaneInfo planeInfo);

    public void updatePlaneInfo(PlaneInfo PlaneInfo);

}
