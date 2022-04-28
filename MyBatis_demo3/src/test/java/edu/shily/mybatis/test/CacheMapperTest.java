package edu.shily.mybatis.test;

import edu.shily.mybatis.mapper.CacheMapper;
import edu.shily.mybatis.pojo.Emp;
import edu.shily.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @author Shily-zhang
 * @Description 一级缓存主要针对查询操作，默认开启,范围就是sqlSession
 */
public class CacheMapperTest  {

    @Test
    public void testCacheOne(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
//        mapper1.insertEmp(new Emp(null,"abc",23,"男","123@qq.com"));
        sqlSession1.clearCache();//手动清理缓存
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
//        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
//        Emp emp2 = mapper2.getEmpByEid(1);
//        System.out.println(emp2);
    }

    @Test
    public void testCacheTwo()  {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
