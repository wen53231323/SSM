package Spring.Service.impl;


import Spring.Dao.UserDao;
import Spring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // 获取数据访问层对象
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void saveUser() {
        // 模拟调用插入数据
        userDao.insertUser();
        System.out.println("添加成功");
    }
}
