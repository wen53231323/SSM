package Spring.Controller;

import Spring.Service.BookService;
import Spring.Service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// @Controller：将类标识为控制层组件
@Controller
public class BookController {

    // 业务层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private BookService bookService;

    // 买书
    public void buyBook(Integer userId,Integer bookId){
        bookService.buyBook(userId,bookId);

    }

    // 业务层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    private CheckoutService checkoutService;

    // 结账（买多本书）
    public void checkout(Integer userId,Integer[] bookIds){
        checkoutService.checkout(userId,bookIds);
    }
}
