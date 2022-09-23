import Spring.Controller.BookController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式，直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring测试环境的配置文件
@ContextConfiguration("classpath:基于注解的声明式事务.xml")
public class 测试事务 {
    // 控制层对象
    // @Autowired：自动装配,根据指定的策略，在IOC容器中匹配某一个bean，自动为指定的bean中所依赖的类类型或接口类型属性赋值
    @Autowired
    BookController bookController;

    // 买书事务
    @Test
    public void buyBook(){
        // 1号用户买1号图书
        bookController.buyBook(1,1);
    }

    // 买多本书事务
    @Test
    public void buyBooks(){
        // 1号用户买1号图书和2号图书
        bookController.checkout(1,new Integer[]{2,1});
    }
}
