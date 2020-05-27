package com.chinasoftinternational.uav.dao.impl;

import com.chinasoftinternational.uav.bean.PlaneInfo;
import com.chinasoftinternational.uav.dao.PlaneInfoDao;
import com.chinasoftinternational.uav.mapper.PlaneInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName PlaneInfoService.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:38
 */
@Repository
public class PlaneInfoDaoImpl implements PlaneInfoDao {

    @Autowired
    private PlaneInfoMapper planeInfoMapper;

    @Override
    public PlaneInfo findPlaneInfoByPlaneName(String planeName) throws RuntimeException {
        return planeInfoMapper.findPlaneInfoByPlaneName(planeName);
    }

    @Override
    public void insertOrUpdatePlaneInfo(PlaneInfo planeInfo) throws RuntimeException {
        PlaneInfo bean = this.findPlaneInfoByPlaneName(planeInfo.getPlaneName());
        if(bean == null) {
            planeInfoMapper.insertPlaneInfo(planeInfo);
        } else {
            planeInfoMapper.updatePlaneInfo(planeInfo);
        }
    }
}
