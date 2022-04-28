package edu.shily.mybatis.test;

import edu.shily.mybatis.mapper.SelectMapper;
import edu.shily.mybatis.pojo.User;
import edu.shily.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Map;

/**
 * @author Shily-zhang
 * @Description MyBatis查询功能
 *          1.若查询出的数据只有一条，
 *          a>可以通过实体类对象接收
 *          b>可以通过list集合接收
 *          c>可以通过map集合接收
 *          结果：{password=123456, sex=男, id=13, age=23, email=123@qq.com, username=李四}
 *          以字段为键，字段的值为值
 *
 *          2.若查询出的数据有多条，
 *          a>可以通过List集合接收，
 *          b>可以通过map类型的list集合接收
 *          c>可以在mapper接口的方法上添加@MapKey注解，此时可以将每条数据转换的map集合作为值，以某个字段的值作为键，然后放在同一个map中
 *          注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
 *
 * MyBatis中设置了默认的类型别名
 * java.lang.Integer -> int,interger
 * int -> _int,_interger
 * Map -> map
 * String -> string
 */
public class SelectMapperTest {

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(13));
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetALlUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        for (User user : mapper.getAllUser()) {
            System.out.println(user);
        }

    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(6));
    }

}
