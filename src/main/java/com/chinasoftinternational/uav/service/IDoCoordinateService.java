package com.chinasoftinternational.uav.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName IDoCoordinateDao.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 16:02
 */
public interface IDoCoordinateService {

    @Transactional
    public String getCoordinateInfo(Integer signalIndex, String textContext) throws RuntimeException;

}
