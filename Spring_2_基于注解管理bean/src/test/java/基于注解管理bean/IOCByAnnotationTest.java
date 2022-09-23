package 基于注解管理bean;

import Spring.Controller.UserController;
import Spring.Dao.UserDao;
import Spring.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {
    @Test
    public void Test(){
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("基于注解管理bean.xml");
        // 获取IOC容器中的Bean
        UserController bean1 = ioc.getBean(UserController.class);
        UserService bean2 = ioc.getBean(UserService.class);
        UserDao bean3 = ioc.getBean(UserDao.class);
        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);
    }
}
