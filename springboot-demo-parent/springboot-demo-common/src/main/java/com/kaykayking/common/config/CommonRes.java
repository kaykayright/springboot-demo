package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 11:15 下午 2022/7/26.
 * @Modified By:
 */

/**
 * todo
 *
 * @author hk
 * @version Id: CommonRes.java, v 0.1 2022/7/26 11:15 下午 Exp $$
 */
public class CommonRes {

    //表名经请求的返回结果,"success" 或 "fail
    private String status;

    private Object data;


    public static CommonRes create(Object result){

        return  CommonRes.create(result,"success");

    }

    public static CommonRes create(Object result, String status){

        CommonRes commonRes = new CommonRes();
        commonRes.setData(result);
        commonRes.setStatus(status);
        return commonRes;

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}