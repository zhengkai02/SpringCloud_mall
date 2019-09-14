package com.zk.sell.utils;

import com.zk.sell.VO.ResultVO;

/**
 * @author ZhengKai
 * @data 2019-09-09 17:08
 */
public class ResultVOUtil {
    private static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("Success");
        resultVO.setData(object);
        return resultVO;
    }
}
