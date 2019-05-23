package com.chinasoftinternational.uav.controller;

import com.chinasoftinternational.uav.service.IDoCoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CoordinateController.java
 * @Description 控制器
 * @Author Jesse Lin
 * @Since 2019/5/11 17:49
 */
@RestController
public class CoordinateController {

    @Autowired
    IDoCoordinateService iDoCordinateService;
    /**
     *
     * @param signalIndex 序号
     * @param textContext 文本内容
     * @return
     */
    @RequestMapping("/getCoordinateInfo")
    public String getCoordinateInfo(@RequestParam("signalIndex") Integer signalIndex,
                                    @RequestParam("textContext") String textContext) {
        return iDoCordinateService.getCoordinateInfo(signalIndex, textContext);

    }

}
