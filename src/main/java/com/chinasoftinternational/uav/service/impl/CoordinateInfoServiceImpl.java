package com.chinasoftinternational.uav.service.impl;

import com.chinasoftinternational.uav.bean.CoordinateInfo;
import com.chinasoftinternational.uav.dao.CoordinateInfoDao;
import com.chinasoftinternational.uav.service.CoordinateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName StartCoordinateInfoServiceImpl.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:09
 */
@Service
@Transactional
public class CoordinateInfoServiceImpl implements CoordinateInfoService {

    @Autowired
    private CoordinateInfoDao iCoordinateInfoDao;

    @Override
    public void insertCoordinateInfo(CoordinateInfo coordinateInfo) throws RuntimeException {
        iCoordinateInfoDao.insertCoordinateInfo(coordinateInfo);
    }


}
