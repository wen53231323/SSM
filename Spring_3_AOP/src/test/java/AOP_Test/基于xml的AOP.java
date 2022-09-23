package AOP_Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import 基于xml的AOP.Calculator;

public class 基于xml的AOP {
    @Test
    public void TestAOPByAnnotation(){
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("基于xml的AOP.xml");
        // 获取IOC容器中的Bean
        Calculator bean = ioc.getBean(Calculator.class);
        // 调用方法
        bean.add(1, 2);
    }
}
