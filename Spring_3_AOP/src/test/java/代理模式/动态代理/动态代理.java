package 代理模式.动态代理;


import org.junit.Test;
import 代理模式.Calculator;
import 代理模式.CalculatorImpl;

public class 动态代理 {
    @Test
    public void Test(){
        // 传入目标对象，造对象
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        // 调用方法创建动态代理类
        Calculator proxy = (Calculator) factory.getProxy();
        // 调用方法
        int add = proxy.add(1, 3);
    }
}
