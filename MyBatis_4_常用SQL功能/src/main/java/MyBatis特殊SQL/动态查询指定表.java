package MyBatis特殊SQL;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.util.List;

public class 动态查询指定表 {

    @Test
    public void getUserByLike() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // // 使用实现类对象，调用Mapper接口的方法
        List<User> t_user = mapper.getUserByTable("t_user");
        System.out.println(t_user);
        t_user.forEach(System.out::println);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
