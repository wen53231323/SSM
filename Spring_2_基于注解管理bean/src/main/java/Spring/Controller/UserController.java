package Spring.Controller;



import Spring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController {
    // 获取业务层对象
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    // 添加用户
    public void saveUser(){
        System.out.println("模拟添加用户开始");
        userService.saveUser();
    }
}
