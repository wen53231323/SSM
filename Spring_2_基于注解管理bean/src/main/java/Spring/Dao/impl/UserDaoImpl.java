package Spring.Dao.impl;


import Spring.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void insertUser() {
        System.out.println("模拟插入数据：insert into from User(id,name) values(1001,'小明')");
    }
}
