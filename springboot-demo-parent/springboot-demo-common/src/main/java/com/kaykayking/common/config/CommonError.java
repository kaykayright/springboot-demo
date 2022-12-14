package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 11:23 下午 2022/7/26.
 * @Modified By:
 */

/**
 * todo
 *
 * @author hk
 * @version Id: CommonError.java, v 0.1 2022/7/26 11:23 下午 Exp $$
 */
public class CommonError {


    private Integer errCode;

    private String errMsg;


    public CommonError(Integer errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    public CommonError(EmBusinessError emBusinessError) {
        this.errCode = emBusinessError.getErrCode();
        this.errMsg = emBusinessError.getErrMsg();
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}