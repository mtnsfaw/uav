package com.chinasoftinternational.uav.service;

/**
 * @ClassName IDoCoordinateDao.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 16:02
 */
public interface IDoCoordinateService {

    public String getCoordinateInfo(Integer signalIndex, String textContext) throws RuntimeException;

}
