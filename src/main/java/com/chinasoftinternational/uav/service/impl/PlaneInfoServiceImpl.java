package com.chinasoftinternational.uav.service.impl;

import com.chinasoftinternational.uav.bean.PlaneInfo;
import com.chinasoftinternational.uav.dao.PlaneInfoDao;
import com.chinasoftinternational.uav.service.PlaneInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName PlaneInfoService.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:38
 */
@Service
@Transactional
public class PlaneInfoServiceImpl implements PlaneInfoService {

    @Autowired
    private PlaneInfoDao iPlaneInfoDao;

    @Override
    public PlaneInfo findPlaneInfoByPlaneName(String planeName) throws RuntimeException {
        return iPlaneInfoDao.findPlaneInfoByPlaneName(planeName);
    }

    @Override
    public void insertOrUpdatePlaneInfo(PlaneInfo planeInfo) throws RuntimeException {
        iPlaneInfoDao.insertOrUpdatePlaneInfo(planeInfo);
    }
}
