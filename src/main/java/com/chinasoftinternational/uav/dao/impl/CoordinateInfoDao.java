package com.chinasoftinternational.uav.dao.impl;

import com.chinasoftinternational.uav.bean.CoordinateInfo;
import com.chinasoftinternational.uav.dao.ICoordinateInfoDao;
import com.chinasoftinternational.uav.mapper.CoordinateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName StartCoordinateInfoServiceImpl.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 15:09
 */
@Repository
public class CoordinateInfoDao implements ICoordinateInfoDao {

    @Autowired
    private CoordinateInfoMapper coordinateInfoMapper;

    @Override
    public void insertCoordinateInfo(CoordinateInfo coordinateInfo) throws RuntimeException {
        coordinateInfoMapper.insertCoordinateInfo(coordinateInfo);
    }


}
