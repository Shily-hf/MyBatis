package edu.shily.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.shily.mybatis.mapper.EmpMapper;
import edu.shily.mybatis.pojo.Emp;
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
public class PageHelperTest {

    /**
     * limit index pageSize
     * index:当前起始索引
     * pageSize:每页显示的条数
     * pageNum:当前页的页码
     * index=(pageNum-1)*pageSize
     *
     * 使用Mybatis的分页插件实现分页功能：
     * 1.需要在查询功能之前开启分页
     * PageHelper.startPage(int pageNum,int pageSize);
     *
     * 2.在查询功能之后获取分页相关信息
     *PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
     * list：表示分页数据
     * 5:表示当前导航分页的数量
     */
    @Test
    public void testPageHelper(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
//            Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(5, 4);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
//            for (Emp emp : list){
//                System.out.println(emp);
//            }
            System.out.println(pageInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
