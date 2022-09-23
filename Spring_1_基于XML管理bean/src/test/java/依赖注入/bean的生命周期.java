package 依赖注入;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.User;

public class bean的生命周期 {
    @org.junit.Test
    public void Test() {
        // 指定配置文件，获取IOC容器
        // ConfigurableApplicationContext是ApplicationContext的子接口，其中扩展提供了IOC容器的刷新和关闭
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("bean的生命周期.xml");
        // 获取IOC容器中的Bean
        User bean = ioc.getBean(User.class);
        System.out.println(bean);
        // 关闭IOC容器
        ioc.close();
    }
}
