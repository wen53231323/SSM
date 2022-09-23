package 入门案例;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void TestHelloWorld(){
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("HelloWorld.xml");
        // 获取IOC容器中的Bean
        HelloWorld helloworld = (HelloWorld) ioc.getBean("helloworld");
        // 调用类中方法
        helloworld.sayHello();
    }
}
