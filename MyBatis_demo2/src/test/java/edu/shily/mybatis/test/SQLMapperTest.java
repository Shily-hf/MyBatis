package edu.shily.mybatis.test;

import edu.shily.mybatis.mapper.SQLMapper;
import edu.shily.mybatis.mapper.SelectMapper;
import edu.shily.mybatis.pojo.User;
import edu.shily.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author Shily-zhang
 * @Description
 */
public class SQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("3,4,5,6");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTabelName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "男", "123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

//    @Test
//    public void testJDBC() throws Exception {
//        Class.forName("");
//        Connection connection = DriverManager.getConnection("", "", "");
//        PreparedStatement ps = connection.prepareStatement("insert ", Statement.RETURN_GENERATED_KEYS);
//        ps.executeUpdate();
//        ResultSet resultSet = ps.getGeneratedKeys();
//
//    }


}
