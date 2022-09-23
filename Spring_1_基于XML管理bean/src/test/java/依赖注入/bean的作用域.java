package 依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.Student;

public class bean的作用域 {
    @org.junit.Test
    public void Test() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean的作用域.xml");
        // 获取IOC容器中的Bean
        Student bean1 = ioc.getBean("student1", Student.class);
        Student bean2 = ioc.getBean("student1", Student.class);
        // 判断是否为同一个对象
        System.out.println(bean1 == bean2); // true

        // 获取IOC容器中的Bean
        Student bean3 = ioc.getBean("student2", Student.class);
        Student bean4 = ioc.getBean("student2", Student.class);
        // 判断是否为同一个对象
        System.out.println(bean3 == bean4); // false
    }
}
