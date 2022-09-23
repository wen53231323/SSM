package MyBatis各种查询功能;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;

public class 查询单个数据 {
    @Test
    public void getCount() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        int count = mapper.getCount();
        System.out.println(count);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
