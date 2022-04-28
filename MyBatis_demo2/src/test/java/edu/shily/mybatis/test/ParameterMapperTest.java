package edu.shily.mybatis.test;

import edu.shily.mybatis.mapper.ParameterMapper;
import edu.shily.mybatis.pojo.User;
import edu.shily.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shily-zhang
 * @Description MyBatis获取参数值的两种方式：${} 和 #{}
 * ${}:本质是字符串拼接
 * #{}:本质是占位符赋值
 * MyBatis获取参数值的各种情况
 * 1.mapper接口方法的参数为单个字面量类型
 * 可以通过${}和#{}以任意字符串获取参数值，但需要注意${}的单引号问题
 *
 * 2.mapper接口方法的参数为多个时
 * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
 * a>以arg0，arg1...为键，以参数为值
 * b>以param1,param2...为键，参数为值
 * 可以通过${}和#{}以任意字符串获取参数值，但需要注意${}的单引号问题
 *
 * 3.mapper接口方法的参数为多个时，可以手动将这些参数放在一个map中存储
 * 可以通过${}和#{}以任意字符串获取参数值，但需要注意${}的单引号问题
 *
 * 4.mapper接口方法的参数是实体类型的参数    *********************重点
 * 可以通过${}和#{}以属性的方式获取属性值，但需要注意${}的单引号问题
 *
 * 5.使用@Param注解命名参数             *********************重点
 *此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
 * a>以@Param注解的值为键，以参数为值
 * b>以param1,param2...为键，参数为值
 * 可以通过${}和#{}以任意字符串获取参数值，但需要注意${}的单引号问题
 */
public class ParameterMapperTest {

    @Test
    public void  testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User admin1 = mapper.checkLoginByParam("admin1", "123456");
        System.out.println(admin1);

    }


    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123456", 23, "男", "123@qq.com"));
        System.out.println("result:" + result);
    }

    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","ybc");
        map.put("password","123");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("ybc", "123");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("ybc");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> userList = mapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testJDBC() throws Exception {
        String username = "admin";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
//        connection.prepareStatement("select * from t_user where username = '" + username + "'");
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ?");
        ps.setString(1,username);

    }

}
