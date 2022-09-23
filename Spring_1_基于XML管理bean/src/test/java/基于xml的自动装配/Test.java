package 基于xml的自动装配;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import 基于xml的自动装配.Controller.UserController;

public class Test {
    @org.junit.Test
    public void test(){
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("基于xml的自动装配.xml");
        // 获取IOC容器中的Bean
        UserController bean = ioc.getBean(UserController.class);

        // 调用Controller中的操作
        bean.saveUser();
    }
}
