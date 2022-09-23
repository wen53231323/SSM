package 依赖注入;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class 引入外部属性文件 {
    @org.junit.Test
    public void Test() throws SQLException {
        // 指定配置文件，获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("引入外部属性文件.xml");
        // 获取IOC容器中的Bean
        // 硬编码方式
        DruidDataSource bean1 = ioc.getBean("Test", DruidDataSource.class);
        // 引入外部属性文件方式
        DruidDataSource bean2 = ioc.getBean("druidDataSource", DruidDataSource.class);
        // 获取数据库连接
        System.out.println(bean1.getConnection());
        System.out.println(bean2.getConnection());
    }
}
