package 依赖注入;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.pojo.Clazz;
import spring.pojo.Student;

public class 依赖注入 {
    // ====================================setter注入方式====================================
    @org.junit.Test
    public void Test_1() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_1", Student.class);
        System.out.println(studentOne);
    }
    // ====================================构造器注入方式====================================
    @org.junit.Test
    public void Test_2() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_2", Student.class);
        System.out.println(studentOne);
    }

    // ====================================特殊值处理====================================
    @org.junit.Test
    public void Test_tsz() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_tsz", Student.class);
        System.out.println(studentOne);
    }

    // ====================================为 类 类型属性赋值（级联属性赋值方式）====================================
    @org.junit.Test
    public void Test_3() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_3", Student.class);
        System.out.println(studentOne);
    }

    // ====================================为 类 类型属性赋值（引用外部已声明的bean方式）====================================
    @org.junit.Test
    public void Test_4() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_4", Student.class);
        System.out.println(studentOne);
    }

    // ====================================为 类 类型属性赋值（内部bean方式）====================================
    @org.junit.Test
    public void Test_5() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_5", Student.class);
        System.out.println(studentOne);
    }
    // ====================================为数组类型属性赋值====================================
    @org.junit.Test
    public void Test_6() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student studentOne = ac.getBean("student_6", Student.class);
        System.out.println(studentOne);
    }

    // ==============================为集合类型属性赋值（list和set）====================
    @org.junit.Test
    public void Test_List() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        // 方式一：使用标签<list>配置
        Clazz clazz_2 = ac.getBean("clazz_2", Clazz.class);
        // 方式二：使用util的约束，配置一个集合类型的bean
        Clazz clazz_3 = ac.getBean("clazz_3", Clazz.class);
        // System.out.println(clazz_2);
        System.out.println(clazz_3);
    }

    // ============================== 为集合类型属性赋值（map）==============================
    @org.junit.Test
    public void Test_map() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        // 方式一：使用标签<map>配置
        Student student_7 = ac.getBean("student_7", Student.class);
        // 方式二：使用util的约束，配置一个集合类型的bean
        Student student_8 = ac.getBean("student_8", Student.class);
        //System.out.println(student_7);
        System.out.println(student_8);
    }

    // ==============================p命名空间==============================
    @org.junit.Test
    public void Test_p() {
        // 指定配置文件，获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("依赖注入.xml");
        // 获取IOC容器中的Bean
        Student student_9 = ac.getBean("student_9", Student.class);
        System.out.println(student_9);
    }

}
