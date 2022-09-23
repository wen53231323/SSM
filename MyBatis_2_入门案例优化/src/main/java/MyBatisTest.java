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
import java.util.Iterator;
import java.util.List;

public class MyBatisTest {

    @Test
    public void Test_Insert_User() throws IOException {
        // 获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 根据核心配置文件的输入流，获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取sql的会话对象SqlSession，是MyBatis提供的操作数据库的对象
        // SqlSession默认不自动提交事务，若需要自动提交事务
        // 可以使用SqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 执行sql方式一：
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用实现类对象，调用Mapper接口的方法测试添加功能
        int result1 = mapper.insertUser();

        // 执行sql方式二：
        // 提供sql语句的唯一标识，找到sql语句并执行，唯一标识是映射文件中的namespace.sqlId
        int result2 = sqlSession.insert("mapper.UserMapper.insertUser");

        // 提交事务
        // sqlSession.commit();
        // 关闭sqlSession对象
        sqlSession.close();
        System.out.println("结果:" + result1);
        System.out.println("结果:" + result2);
    }


    @Test
    public void Test_Update_User() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用实现类对象，调用Mapper接口的方法，实现更新用户信息操作
        mapper.updateUser();
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void Test_Delete_User() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用实现类对象，调用Mapper接口的方法，实现删除用户信息操作
        mapper.deleteUser();
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void Test_Select_GetUserById() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用实现类对象，调用Mapper接口的方法，实现根据id查询用户信息操作
        User userById = mapper.getUserById();
        System.out.println("用户ID为1的信息：" + userById);
        // 关闭sqlSession对象
        sqlSession.close();
    }

    @Test
    public void Test_Select_GetAllUser() {
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 使用实现类对象，调用Mapper接口的方法，实现查询所有用户信息操作
        List<User> allUser = mapper.getAllUser();
        System.out.println("List<User>集合数据：" + allUser);

        // 遍历集合
        //方式一：Iterator迭代器
        System.out.println("遍历集合方式一：");
        Iterator iterator = allUser.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //方式二：增强for循环foreach
        System.out.println("遍历集合方式二：");
        for (Object i : allUser) {
            System.out.println(i);
        }
        //方式三：普通for循环
        System.out.println("遍历集合方式三：");
        for (int i = 0; i < allUser.size(); i++) {
            System.out.println(allUser.get(i));
        }

        // 关闭sqlSession对象
        sqlSession.close();
    }

}
