import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import pojo.User;
import utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void Test_Select_getUserByUsername() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法，实现根据用户名查询用户信息操作（#{}方式）
        User userByUsername1 = mapper.getUserByUsername_1("张三");
        System.out.println(userByUsername1);
        // 使用实现类对象，调用Mapper接口的方法，实现根据用户名查询用户信息操作（${}方式）
        User userByUsername2 = mapper.getUserByUsername_2("张三");
        System.out.println(userByUsername2);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void Test_checklogin() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法，实现根据用户名查询用户信息操作（#{}方式，age0,age1,...获取）
        User user1 = mapper.checklogin_1("张三", "123456");
        System.out.println(user1);
        // 使用实现类对象，调用Mapper接口的方法，实现根据用户名查询用户信息操作（${}方式，param1,param2,...获取）
        User user2 = mapper.checklogin_2("张三", "123456");
        System.out.println(user2);
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void checkloginByMap() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 创建一个map集合
        Map<String, Object> map = new HashMap<>();
        // 设置用户名和密码
        map.put("username", "张三");
        map.put("password", "123456");
        // 使用实现类对象，调用Mapper接口的方法
        User user = mapper.checkloginByMap(map);
        System.out.println(user);
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void insertUser() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 创建用户对象
        User user = new User(null, "root", "123",  "男",18,"123@qq.com");
        // 使用实现类对象，调用Mapper接口的方法
        mapper.insertUser(user);

        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void checkloginByParam() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        User user = mapper.checkloginByParam("张三", "123456");
        System.out.println(user);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
