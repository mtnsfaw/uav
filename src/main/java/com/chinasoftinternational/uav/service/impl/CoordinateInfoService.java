package com.chinasoftinternational.uav.service.impl;

import com.chinasoftinternational.uav.bean.CoordinateInfo;
import com.chinasoftinternational.uav.dao.ICoordinateInfoDao;
import com.chinasoftinternational.uav.service.ICoordinateInfoService;
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
public class CoordinateInfoService implements ICoordinateInfoService {

    @Autowired
    private ICoordinateInfoDao iCoordinateInfoDao;

    @Override
    public void insertCoordinateInfo(CoordinateInfo coordinateInfo) throws RuntimeException {
        iCoordinateInfoDao.insertCoordinateInfo(coordinateInfo);
    }


}
