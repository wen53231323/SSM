package MyBatis特殊SQL;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

public class 添加功能获取自增的主键 {
    @Test
    public void insertUser() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User(null, "tom", "123", "男", 18, "123@321.com");
        mapper.insertUser(user);
        System.out.println(user);
        // 输出：User{id=3, username='tom', password='123', gender='男', age=18, email='123@321.com'}
        // 作用：如果不设置，需要再次与数据库交互，查询数据库才能得知用户id
        // 关闭sqlSession对象
        sqlSession.close();
    }
}
