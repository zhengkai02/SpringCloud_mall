package com.zk.sell.utils;

import com.zk.sell.VO.ResultVO;

/**
 * @author ZhengKai
 * @data 2019-09-01 22:30
 */
public class ResultVOUtils {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
