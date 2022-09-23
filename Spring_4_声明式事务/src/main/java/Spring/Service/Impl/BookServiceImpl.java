package Spring.Service.Impl;

import Spring.Dao.BookDao;
import Spring.Dao.Impl.BookDaoImpl;
import Spring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;


// @Transactional：该类中所有的方法会被事务管理
@Transactional(readOnly = true)
// @Service：将类标识为业务层组件
@Service
public class BookServiceImpl implements BookService {

    // 数据访问层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private BookDao bookDao;

    // 买书功能
    // @Transactional：该方法会被事务管理
    // propagation属性：设置事务传播行为
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void buyBook(Integer userId, Integer bookId) {

        try {
            // 休眠5秒
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);

        // 更新图书库存
        bookDao.updateStock(bookId);

        // 更新用户余额
        bookDao.updeBalance(userId, price);

    }
}
