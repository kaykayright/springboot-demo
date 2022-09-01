package com.kaykayking.mybatis.mapper;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 3:11 下午 2022/8/2.
 * @Modified By:
 */

import com.kaykayking.mybatis.pojo.User;

import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: UserMapper.java, v 0.1 2022/8/2 3:11 下午 Exp $$
 */
public interface UserMapper {

    List<User> selectAll();

    User getUserByUsername(String name);


}