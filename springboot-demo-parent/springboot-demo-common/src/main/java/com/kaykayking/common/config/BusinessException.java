package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 11:33 下午 2022/7/26.
 * @Modified By:
 */

/**
 * todo
 *
 * @author hk
 * @version Id: BusinessException.java, v 0.1 2022/7/26 11:33 下午 Exp $$
 */
public class BusinessException extends Exception {

    private CommonError commonError;

    public BusinessException(EmBusinessError emBusinessError){
        super();
        this.commonError = new CommonError(emBusinessError);
    }

    public CommonError getCommonError() {
        return commonError;
    }

    public void setCommonError(CommonError commonError) {
        this.commonError = commonError;
    }
}