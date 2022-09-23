package 一级缓存;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

public class 一级缓存测试 {
    @Test
    public void getEmpById() {
        // 获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();

        // 获取UserMapper的代理实现类对象
        EmpMapper mapper1 = sqlSession1.getMapper(EmpMapper.class);
        EmpMapper mapper2 = sqlSession2.getMapper(EmpMapper.class);

        // 第一次查询员工，此时会打印sql语句
        Emp empById1 = mapper1.getEmpById(1);
        System.out.println(empById1);

        // 第二次查询员工，此时不会打印sql语句，会从一级缓存中查询（SqlSession级别）
        Emp empById2 = mapper1.getEmpById(1);
        System.out.println(empById2);

        // 第三次查询员工，此时会打印sql语句（由于查询条件不同）
        Emp empById3 = mapper1.getEmpById(2);
        System.out.println(empById3);

        // 第四次查询员工，此时会打印sql语句（由于使用了新的SqlSession对象）
        Emp empById4 = mapper2.getEmpById(1);
        System.out.println(empById4);

        // 手动清空一级缓存
        sqlSession1.clearCache();
        sqlSession2.clearCache();

        // 关闭sqlSession对象
        sqlSession1.close();
        sqlSession2.close();
    }
}
