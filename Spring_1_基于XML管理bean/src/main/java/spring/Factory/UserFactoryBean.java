package spring.Factory;

import org.springframework.beans.factory.FactoryBean;
import spring.pojo.User;

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    // 获取的对象是User对象
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    // 返回User的class对象类型
    public Class<?> getObjectType() {
        return User.class;
    }
}
