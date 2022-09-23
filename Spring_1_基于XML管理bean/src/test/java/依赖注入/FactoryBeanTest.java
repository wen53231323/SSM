package 依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.User;

public class FactoryBeanTest {
    @org.junit.Test
    public void Test() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("Factory.xml");
        // 获取IOC容器中的Bean
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
    }
}
