package JdbcTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import Spring.pojo.User;

import java.util.List;

// 指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式，直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    // 自动装配：根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    // 添加一条数据
    public void testInsert() {
        String sql = "insert into t_user values(null,?,?)";
        int result = jdbcTemplate.update(sql, "张三", 200);
        System.out.println(result);
    }

    @Test
    // 根据id查询一条数据为一个实体类对象
    public void testSelectById() {
        String sql = "select * from t_user where user_id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        System.out.println(user);
    }

    @Test
    // 查询多条数据为一个list集合
    public void testSelectList() {
        String sql = "select * from t_user";
        List<User> user_list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        user_list.forEach(user -> System.out.println(user));
    }

    @Test
    //查询单行单列的值
    public void selectCount() {
        String sql = "select count(user_id) from t_user";
        // queryForObject(sql语句,返回值类型,参数)
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

}


