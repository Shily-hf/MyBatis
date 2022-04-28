package edu.shily.mybatis.mapper;

import edu.shily.mybatis.pojo.User;

import java.util.List;

/**
 * Mybatis面向接口编程的两个一致
 * 1.映射文件的namespace要和mapper接口的全类名保持一致
 * 2.映射文件中的sql语句的id要和mapper中的方法名一致
 *
 * 表---实体类---mapper接口---映射文件
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
     void updateUser();

    /**
     * 删除用户信息
     */
     void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     *查询用户所有信息
     */
    List<User> getAllUser();
}
