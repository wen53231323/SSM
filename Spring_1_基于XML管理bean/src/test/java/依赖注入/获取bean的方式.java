package 依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.Person;
import spring.pojo.Student;

// （1）根据bean的id获取
// （2）根据bean的类型获取
// （3）根据根据id和类型获取
// （4）如果组件类实现了接口，根据接口类型获取 bean
public class 获取bean的方式 {
    // （1）根据bean的id获取
    @org.junit.Test
    public void Test_1() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("获取bean的方式.xml");
        // 获取IOC容器中的Bean
        Student student = (Student) ioc.getBean("student");
        System.out.println(student);
    }

    // （2）根据bean的类型获取
    @org.junit.Test
    public void Test_2() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("获取bean的方式.xml");
        // 获取IOC容器中的Bean
        Student student = ioc.getBean(Student.class);
        System.out.println(student);
    }

    // （3）根据根据id和类型获取
    @org.junit.Test
    public void Test_3() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("获取bean的方式.xml");
        // 获取IOC容器中的Bean
        Student student = ioc.getBean("student", Student.class);
        System.out.println(student);
    }

    // （4）如果组件类实现了接口，根据接口类型获取 bean
    @org.junit.Test
    public void Test_4() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("获取bean的方式.xml");
        // 获取IOC容器中的Bean
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}
