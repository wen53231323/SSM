package 逆向工程测试;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;
import 逆向工程MyBatis3尊享版.mapper.EmpMapper;
import 逆向工程MyBatis3尊享版.pojo.EmpExample;

public class 删除测试 {
    // 根据主键删除
    @Test
    public void Test_1() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        int i = mapper.deleteByPrimaryKey(16);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    // 根据条件删除，删除姓名为小明的用户
    @Test
    public void Test_2() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 创建EmpExample对象
        EmpExample example = new EmpExample();
        // 创建条件对象
        example.createCriteria().andEmpNameEqualTo("小明");
        mapper.deleteByExample(example);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
