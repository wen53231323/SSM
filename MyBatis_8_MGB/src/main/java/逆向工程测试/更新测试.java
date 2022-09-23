package 逆向工程测试;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;
import 逆向工程MyBatis3尊享版.mapper.EmpMapper;
import 逆向工程MyBatis3尊享版.pojo.Emp;

public class 更新测试 {
    // 根据主键修改，如果有null值则将null替换原有值
    @Test
    public void Test_1() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建emp实体类对象（需要在实体类中添加有参构造器和无参构造器）
        Emp emp = new Emp(1, "小明", null, "男", 1);

        // 根据主键修改，如果有null值则将null填入
        int i = mapper.updateByPrimaryKey(emp);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    // 选择性修改，如果有null值，则不会改变原有值
    @Test
    public void Test_2() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建emp实体类对象（需要在实体类中添加有参构造器和无参构造器）
        Emp emp = new Emp(1, "小明", null, "男", 1);

        // 选择性修改，如果有null值则不会改变原有值
        mapper.updateByPrimaryKeySelective(emp);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
