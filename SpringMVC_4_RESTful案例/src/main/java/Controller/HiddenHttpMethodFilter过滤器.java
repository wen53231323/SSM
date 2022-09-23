package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HiddenHttpMethodFilter过滤器 {

    // 查询所有用户
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户");
        return "success";
    }

    // 根据id查询用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询用户");
        return "success";
    }

    // 添加用户
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser() {
        System.out.println("添加用户");
        return "success";
    }

    // 删除用户
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("删除用户");
        return "success";
    }

    // 修改用户
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("修改用户");
        return "success";
    }

}
