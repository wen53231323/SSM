package spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor {
    @Override
    // 此方法在bean的声明周期初始化之前执行
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("☆☆☆后置处理器postProcessBeforeInitialization(" +beanName + " = " + bean);
        return bean;
    }

    @Override
    // 此方法在bean的声明周期初始化之后执行
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("★★★后置处理器postProcessAfterInitialization" + beanName + " = " + bean);
        return bean;
    }
}