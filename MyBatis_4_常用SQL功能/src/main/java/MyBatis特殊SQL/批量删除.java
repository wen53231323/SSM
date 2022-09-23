package MyBatis特殊SQL;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;

public class 批量删除 {
    @Test
    public void deleteMore() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
