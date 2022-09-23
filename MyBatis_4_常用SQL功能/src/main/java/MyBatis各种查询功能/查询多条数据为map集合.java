package MyBatis各种查询功能;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class 查询多条数据为map集合 {
    @Test
    public void getAllUserToMap() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        // 查询所有用户信息为map集合方式一
        List<Map<String, Object>> allUserToMap_1 = mapper.getAllUserToMap_1();
        System.out.println(allUserToMap_1);
        // 查询所有用户信息为map集合方式二
        Map<String, Object> allUserToMap_2 = mapper.getAllUserToMap_2();
        System.out.println(allUserToMap_2);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
