package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestExceptionController {
    // 测试异常处理器
    @RequestMapping("/testError")
    public String test() {
        // 数学运算异常
        System.out.println(1/0);
        return "success";
    }

}
