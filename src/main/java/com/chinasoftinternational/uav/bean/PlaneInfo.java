package com.chinasoftinternational.uav.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName PlaneInfo.java
 * @Description 飞机情况实体类
 * @Author Jesse Lin
 * @Since 2019/5/11 15:15
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class PlaneInfo {

    private Integer id;
    /**
     * 飞机名称
     */
    private String planeName;
    /**
     * 当前所处序号
     */
    private Integer curIndex;
    /**
     * 状态:0-正常，1-故障
     */
    private Integer status;
    /**
     * 当前坐标
     */
    private String curCoordinate;
    /**
     * 上一个坐标
     */
    private String preCoordinate;

    public PlaneInfo(String planeName, Integer curIndex, Integer status, String curCoordinate, String preCoordinate) {
        this.planeName = planeName;
        this.curIndex = curIndex;
        this.status = status;
        this.curCoordinate = curCoordinate;
        this.preCoordinate = preCoordinate;
    }

}
