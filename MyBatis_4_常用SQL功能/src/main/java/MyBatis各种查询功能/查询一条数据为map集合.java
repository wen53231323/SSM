package MyBatis各种查询功能;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;

import java.util.Map;

public class 查询一条数据为map集合 {
    @Test
    public void getUserToMap() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        Map<String, Object> userToMap = mapper.getUserToMap(1);
        System.out.println(userToMap);
        // {password=123456, gender=男, id=1, age=18, email=123@qq.com, username=张三}

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
