package com.chinasoftinternational.uav.bean;

/**
 * @ClassName PlaneInfo.java
 * @Description 飞机情况实体类
 * @Author Jesse Lin
 * @Since 2019/5/11 15:15
 */
public class PlaneInfo {

    private Integer id;
    private String planeName;//飞机名称
    private Integer curIndex;//当前所处序号
    private Integer status;//状态:0-正常，1-故障
    private String curCoordinate;//当前坐标
    private String preCoordinate;//上一个坐标

    public PlaneInfo() {
    }

    public PlaneInfo(String planeName, Integer curIndex, Integer status, String curCoordinate, String preCoordinate) {
        this.planeName = planeName;
        this.curIndex = curIndex;
        this.status = status;
        this.curCoordinate = curCoordinate;
        this.preCoordinate = preCoordinate;
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

    public Integer getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(Integer curIndex) {
        this.curIndex = curIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCurCoordinate() {
        return curCoordinate;
    }

    public void setCurCoordinate(String curCoordinate) {
        this.curCoordinate = curCoordinate;
    }

    public String getPreCoordinate() {
        return preCoordinate;
    }

    public void setPreCoordinate(String preCoordinate) {
        this.preCoordinate = preCoordinate;
    }
}
