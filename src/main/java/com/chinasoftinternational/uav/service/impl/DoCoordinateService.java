package com.chinasoftinternational.uav.service.impl;

import com.chinasoftinternational.uav.bean.CoordinateInfo;
import com.chinasoftinternational.uav.bean.PlaneInfo;
import com.chinasoftinternational.uav.service.ICoordinateInfoService;
import com.chinasoftinternational.uav.service.IDoCoordinateService;
import com.chinasoftinternational.uav.service.IPlaneInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @ClassName DoCoordinateService.java
 * @Description Too
 * @Author Jesse Lin
 * @Since 2019/5/11 16:04
 */
@Service
@Transactional
public class DoCoordinateService implements IDoCoordinateService {

    @Autowired
    private ICoordinateInfoService iCoordinateInfoService;
    @Autowired
    private IPlaneInfoService iPlaneInfoService;

    @Override
    public String getCoordinateInfo(Integer signalIndex, String textContext) throws RuntimeException {
        String result = validateParam(signalIndex, textContext);

        if(!StringUtils.isEmpty(result)) {
            return result;
        }

        String[] contextArry = textContext.split(" ");
        String planeName = contextArry[0];
        /*
         * 坐标（除开飞机ID）
         */
        String coordinateStr = this.getStrFormArry(contextArry, 1, contextArry.length);

        /*
         * 当前位置坐标
         */
        String curCoordinate = this.getStrFormArry(contextArry, 1, 3);
        /*
         * 偏移量
         */
        String vectorStr = contextArry.length==7 ? this.getStrFormArry(contextArry, 4, 6) : "";
        /*
         *目标位置
         */
        String destinationLocation = this.getDestinationLocation(curCoordinate, vectorStr);

        PlaneInfo planeInfo = iPlaneInfoService.findPlaneInfoByPlaneName(planeName);

        if(planeInfo == null) {
            if(signalIndex == 0 && contextArry.length == 4) {//起始
                iPlaneInfoService.insertOrUpdatePlaneInfo(new PlaneInfo(planeName, signalIndex, 0, coordinateStr, ""));
                iCoordinateInfoService.insertCoordinateInfo(new CoordinateInfo(planeName, signalIndex, textContext));
                result = planeName + " "+ signalIndex + " " + destinationLocation;
            } else {
                result = "Cannot find " + signalIndex;
            }
        } else {
            //故障
            if(planeInfo.getStatus() == 1) {
                if(planeInfo.getCurIndex()+1>=signalIndex) {
                    result = "error" + signalIndex;
                } else {
                    result = "Cannot find " + signalIndex;
                }
                return result;
            }

            //输入的参数跟上一次是一样的
            if(signalIndex.equals(planeInfo.getCurIndex()) && coordinateStr.equals(planeInfo.getCurCoordinate())) {
                return textContext;
            }

            if(planeInfo.getCurIndex()+1<signalIndex) {
                iPlaneInfoService.insertOrUpdatePlaneInfo(new PlaneInfo(planeName, planeInfo.getCurIndex(), 1, "NA NA NA", planeInfo.getCurCoordinate()));
                iCoordinateInfoService.insertCoordinateInfo(new CoordinateInfo(planeName, signalIndex, textContext));
                return "Cannot find " + signalIndex;
            } else if(planeInfo.getCurIndex()+1>signalIndex || (planeInfo.getCurIndex()+1==signalIndex && (contextArry.length == 4 || !planeInfo.getCurCoordinate().equals(curCoordinate)))) {
                iPlaneInfoService.insertOrUpdatePlaneInfo(new PlaneInfo(planeName, planeInfo.getCurIndex(), 1, "NA NA NA", planeInfo.getCurCoordinate()));
                iCoordinateInfoService.insertCoordinateInfo(new CoordinateInfo(planeName, signalIndex, textContext));
                return "error" + signalIndex;
            }

            /*
             * 正常情况
             */
            iPlaneInfoService.insertOrUpdatePlaneInfo(new PlaneInfo(planeName, signalIndex, 0, destinationLocation, planeInfo.getCurCoordinate()));
            iCoordinateInfoService.insertCoordinateInfo(new CoordinateInfo(planeName, signalIndex, textContext));
            result = planeName + " "+ signalIndex + " " + destinationLocation;

        }


        return result;
    }


    /**
     * 校验参数
     * @param signalIndex
     * @param textContext
     * @return
     */
    private String validateParam(Integer signalIndex, String textContext) {
        String result = "";
        if(StringUtils.isEmpty(textContext)) {
            return "消息参数textContext不能为空（且为数字）！";
        }
        if(StringUtils.isEmpty(signalIndex)) {
            return "消息序号参数signalIndex不能为空！";
        }

        String[] contextArry = textContext.split(" ");
        int length = contextArry.length;
        if(length!=4 && length!=7) {
            return "消息参数textContext格式错误！";
        }

        String planeName = contextArry[0];//飞机名称
        String PW_PATTERN = "^[A-Za-z0-9]+$";
        if(!planeName.matches(PW_PATTERN)) {
            return "消息参数textContext中无人机ID必须为字母和数字的组合！";
        }

        String NUM_PATTERN = "^(-)?\\d+$";
        for (int i=1; i<contextArry.length; i++) {
            if(!contextArry[i].matches(NUM_PATTERN)) {
                return "消息参数textContext中坐标必须为数字（负数、0、正数）！";
            }
        }
        return result;
    }

    /**
     * 截取相应区段
     * @param arry
     * @param beginIndex
     * @param endIndex
     * @return
     */
    private String getStrFormArry(String[] arry, int beginIndex, int endIndex) {
        String str = "";
        for (int i = beginIndex; i < arry.length && i <= endIndex; i++) {
            str += " " + arry[i];
        }
        return str.substring(1, str.length());
    }

    /**
     * 根据当前位置和偏移量计算出目标位置
     * @param curCoordinate
     * @param vectorStr
     * @return
     */
    private String getDestinationLocation(String curCoordinate, String vectorStr) {
        if(StringUtils.isEmpty(vectorStr)) {
            return curCoordinate;
        } else {
            String[] curCoordinateArry = curCoordinate.split(" ");
            String[] vectorStrArry = vectorStr.split(" ");

            String[] result = new String[3];
            for(int i=0; i<3; i++) {
                result[i] = Integer.parseInt(curCoordinateArry[i]) + Integer.parseInt(vectorStrArry[i]) + "";
            }
            return this.getStrFormArry(result, 0, result.length);
        }

    }

}
