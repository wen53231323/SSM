package Spring.Service.Impl;

import Spring.Service.BookService;
import Spring.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    // 业务层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private BookService bookService;

    @Override
    // @Transactional：该方法会被事务管理
    @Transactional
    //一次购买多本图书
    public void checkout(Integer userId, Integer[] bookIds) {
        // 每传递一个id，就买一本书
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId,bookId);
        }
    }
}
