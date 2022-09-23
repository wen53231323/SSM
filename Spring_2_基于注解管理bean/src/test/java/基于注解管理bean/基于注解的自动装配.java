package 基于注解管理bean;

import Spring.Controller.UserController;
import Spring.Dao.UserDao;
import Spring.Service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class 基于注解的自动装配 {
    @Test
    public void Test() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("基于注解管理bean.xml");
        // 获取IOC容器中的Bean
        UserController bean = ioc.getBean(UserController.class);
        // 调用添加用户
        bean.saveUser();
    }
}
