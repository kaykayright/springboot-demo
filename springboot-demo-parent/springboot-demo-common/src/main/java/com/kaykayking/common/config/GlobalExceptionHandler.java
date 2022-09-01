package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 11:37 下午 2022/7/26.
 * @Modified By:
 */

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * todo
 *
 * @author hk
 * @version Id: GlobalExceptionHandler.java, v 0.1 2022/7/26 11:37 下午 Exp $$
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonRes doError(HttpServletRequest servletRequest, HttpServletResponse httpServletResponse,Exception ex){
        if(ex instanceof  BusinessException){

            return CommonRes.create(((BusinessException)ex).getCommonError(),"fail");
        }else if(ex instanceof NoHandlerFoundException){
            CommonError commonError = new CommonError(EmBusinessError.NO_HANDLER_FOUND);
            return CommonRes.create(commonError,"fail");
        }
        else {
            CommonError commonError = new CommonError(EmBusinessError.UNKNOW_ERROR);
            return CommonRes.create(commonError,"fail");

        }



    }

}