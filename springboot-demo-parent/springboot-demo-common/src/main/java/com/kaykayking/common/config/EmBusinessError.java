package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 11:24 下午 2022/7/26.
 * @Modified By:
 */

/**
 * todo
 *
 * @author hk
 * @version Id: EmBusinessError.java, v 0.1 2022/7/26 11:24 下午 Exp $$
 */
public enum  EmBusinessError {

    NO_OBJECT_FOUND(10001,"请求对象不存在"),
    UNKNOW_ERROR(10002,"未知错误"),
    NO_HANDLER_FOUND(10003,"未知操作路径"),
    BIND_EXCEPTION_ERROR(10004,"请求参数错误");

    private Integer errCode;
    private String errMsg;

    EmBusinessError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
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