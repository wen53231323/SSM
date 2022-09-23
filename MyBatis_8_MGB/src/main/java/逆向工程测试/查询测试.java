package 逆向工程测试;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;
import 逆向工程MyBatis3尊享版.mapper.EmpMapper;
import 逆向工程MyBatis3尊享版.pojo.Emp;
import 逆向工程MyBatis3尊享版.pojo.EmpExample;

import java.util.List;

public class 查询测试 {

    // 根据主键查询
    @Test
    public void Test_1() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 根据主键查询
        Emp emp = mapper.selectByPrimaryKey(1);
        System.out.println(emp);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    // 根据条件查询所有
    @Test
    public void Test_2() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 根据条件查询，如果条件为null则查询所有
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    // 根据条件查询员工，姓名为张三且年龄大于等于10岁，或者，姓名为李四且年龄大于10岁，的用户
    @Test
    public void Test_3() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建EmpExample对象
        EmpExample example = new EmpExample();
        // 创建条件对象
        // 查询员工姓名为张三且年龄大于10岁
        example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(10);
        // 或者员工姓名为李四
        example.or().andEmpNameEqualTo("李四").andAgeGreaterThan(10);
        // 根据创建的条件查询
        List<Emp> emps1 = mapper.selectByExample(example);
        emps1.forEach(System.out::println);

        // 关闭sqlSession对象
        sqlSession.close();
    }


    // 获取总记录数
    @Test
    public void Test_4() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建EmpExample对象
        EmpExample example = new EmpExample();
        // 获取总记录数
        int count = mapper.countByExample(example);
        System.out.println(count);

    }

    // 根据条件查询年龄为18的总记录数
    @Test
    public void Test_5() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建EmpExample对象
        EmpExample example = new EmpExample();
        example.createCriteria().andAgeEqualTo(18);
        // 获取年龄为18的总记录数
        int count = mapper.countByExample(example);
        System.out.println(count);

    }

}
