package com.kaykayking.common.pojo;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:20 下午 2022/7/26.
 * @Modified By:
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * todo
 *
 * @author hk
 * @version Id: User.java, v 0.1 2022/7/26 10:20 下午 Exp $$
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String password;
}