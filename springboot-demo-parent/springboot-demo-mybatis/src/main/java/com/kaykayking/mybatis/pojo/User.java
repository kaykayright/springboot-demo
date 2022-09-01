package com.kaykayking.mybatis.pojo;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 3:19 下午 2022/8/2.
 * @Modified By:
 */


import java.util.Date;

/**
 * todo
 *
 * @author hk
 * @version Id: User.java, v 0.1 2022/8/2 3:19 下午 Exp $$
 */
public class User {

    private Integer id;
    private Date createAt;
    private Date updateAt;
    private String telphone;
    private String password;
    private String nickName;
    private Integer gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", telphone='" + telphone + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                '}';
    }
}