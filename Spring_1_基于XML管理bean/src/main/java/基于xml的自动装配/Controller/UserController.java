package 基于xml的自动装配.Controller;


import 基于xml的自动装配.Service.UserService;

public class UserController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 添加用户
    public void saveUser(){
        // 调用sevice层的添加用户的操作
        userService.saveUser();
    }
}
