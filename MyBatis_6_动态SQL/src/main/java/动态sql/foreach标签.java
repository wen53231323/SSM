package 动态sql;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.util.Arrays;
import java.util.List;

public class foreach标签 {
    @Test
    public void insertMoreEmp(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp emp1 = new Emp(null, "张三", 18, "男");
        Emp emp2 = new Emp(null, "李四", 18, "男");
        Emp emp3 = new Emp(null, "王五", 18, "男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        // 批量添加数据
         mapper.insertMoreEmp(emps);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void deleteMoreEmpByArray(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Integer [] empIds=new Integer[]{1,2,3};
        // 批量删除数据
        mapper.deleteMoreEmpByArray(empIds);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
