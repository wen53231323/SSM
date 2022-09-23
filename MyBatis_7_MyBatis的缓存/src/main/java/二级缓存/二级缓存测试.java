package 二级缓存;

import mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;

public class 二级缓存测试 {
    @Test
    public void TestSqlSessionFactory() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 根据核心配置文件的输入流，获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取sql的会话对象SqlSession，是MyBatis提供的操作数据库的对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        // 获取UserMapper的代理实现类对象
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);

        // 第一次查询
        Emp empById1 = mapper1.getEmpById(1);
        System.out.println(empById1);

        // 关闭sqlSession对象，一级缓存失效
        sqlSession1.close();

        // 第二次查询
        Emp empById2 = mapper2.getEmpById(1);
        System.out.println(empById2);

        // 关闭sqlSession对象
        sqlSession2.close();
    }
}
