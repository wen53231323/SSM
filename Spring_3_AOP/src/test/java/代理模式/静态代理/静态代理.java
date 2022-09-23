package 代理模式.静态代理;


import org.junit.Test;
import 代理模式.CalculatorImpl;

public class 静态代理 {
    @Test
    public void Test(){
        // 使用代理类的有参构造，为计算器类赋值
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        // 调用方法
        int add = calculatorStaticProxy.add(1, 3);
    }
}
