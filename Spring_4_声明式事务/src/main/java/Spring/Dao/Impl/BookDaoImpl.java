package Spring.Dao.Impl;

import Spring.Dao.BookDao;
import Spring.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository：将类标识为持久层组件
@Repository
public class BookDaoImpl implements BookDao {

    // 获取JdbcTemplate对象，用于操作数据库
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        // queryForObject(sql语句,返回值类型,参数)
        return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
    }

    @Override
    public void updateStock(Integer bookId) {
        String sql = "update t_book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(sql, bookId);

    }

    @Override
    public void updeBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance - ?  where user_id =?";
        jdbcTemplate.update(sql, price, userId);
    }
}
