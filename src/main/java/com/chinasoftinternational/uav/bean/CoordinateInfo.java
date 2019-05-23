package com.chinasoftinternational.uav.bean;


/**
 * @ClassName CoordinateInfo.java
 * @Description 坐标明细实体类
 * @Author Jesse Lin
 * @Since 2019/5/11 15:35
 */
public class CoordinateInfo {
    private Integer id;
    private String planeName;
    private Integer signalIndex;
    private String message;

    public CoordinateInfo() {
    }

    public CoordinateInfo(String planeName, Integer signalIndex, String message) {
        this.planeName = planeName;
        this.signalIndex = signalIndex;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public Integer getSignalIndex() {
        return signalIndex;
    }

    public void setSignalIndex(Integer signalIndex) {
        this.signalIndex = signalIndex;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
