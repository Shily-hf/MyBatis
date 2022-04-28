package edu.shily.mybatis.test;

import edu.shily.mybatis.mapper.EmpMapper;
import edu.shily.mybatis.pojo.Emp;
import edu.shily.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Shily-zhang
 * @Description
 */
public class MBGTest {

    @Test
    public void testMBG(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
            //根据条件查询
//            EmpExample empExample = new EmpExample();
//            empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
//            empExample.or().andDidIsNotNull();
//            List<Emp> emps = mapper.selectByExample(empExample);
//            for (Emp emp:emps){
//                System.out.println(emp);
//            }
            //选择性修改
//            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",null,null,"123@q.com",3));
            //删除所有数据或者删除指定数据
            EmpExample empExample = new EmpExample();
            empExample.createCriteria().andEidBetween(8,11);
            mapper.deleteByExample(empExample);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
