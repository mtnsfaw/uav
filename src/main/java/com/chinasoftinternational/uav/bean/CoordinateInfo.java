package com.chinasoftinternational.uav.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName CoordinateInfo.java
 * @Description 坐标明细实体类
 * @Author Jesse Lin
 * @Since 2019/5/11 15:35
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CoordinateInfo {
    private Integer id;
    private String planeName;
    private Integer signalIndex;
    private String message;

    public CoordinateInfo(String planeName, Integer signalIndex, String message) {
        this.planeName = planeName;
        this.signalIndex = signalIndex;
        this.message = message;
    }

}
