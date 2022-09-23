package 基于xml的自动装配.Service.impl;


import 基于xml的自动装配.Dao.UserDao;
import 基于xml的自动装配.Service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userdao;

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
