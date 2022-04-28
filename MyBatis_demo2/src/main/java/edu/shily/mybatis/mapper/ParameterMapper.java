package edu.shily.mybatis.mapper;

import edu.shily.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 验证登陆（使用@Param）
     */
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 验证登陆（参数为map）
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 验证登陆
     */
    User checkLogin(String name,String password);

    /**
     * 根据用户名查询员工信息
     */
    User getUserByUsername(String username);

    /**
     * 查询所有的员工信息
     */
    List<User> getAllUser();
}
