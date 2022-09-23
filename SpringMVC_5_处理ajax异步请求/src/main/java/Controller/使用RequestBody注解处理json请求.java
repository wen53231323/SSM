package Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class 使用RequestBody注解处理json请求 {

    @RequestMapping("/testRequestBody")
    public void testRequestBody(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        // 接收地址栏后拼接的数据
        System.out.println("id：" + id);
        // 接收请求体数据
        System.out.println("requestBody：" + requestBody);
        // 响应数据
        response.getWriter().write("hello Ajax");
    }

    // @RequestBody处理Ajax请求：将json格式的数据转换为map集合
    @RequestMapping("/testRequestBody_Map")
    public void testRequestBody_map(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);//{username=admin, password=123456}
        // 响应数据
        response.getWriter().print("hello,axios");
    }

    // @RequestBody处理Ajax请求：将json格式的数据转换为实体类对象
    @RequestMapping("/testRequestBody_pojo")
    public void testRequestBody_pojo(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println(user);
        // User{id=null, username='admin', password='123456', age=null,gender='null'}
        response.getWriter().print("hello,axios");
    }
}
