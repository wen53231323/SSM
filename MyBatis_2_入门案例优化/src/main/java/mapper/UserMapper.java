package mapper;


// MyBatis面向接口编程的两个一致
// 映射文件的namespace要和mapper接口的全类名一致
// 映射文件中sql语句的id要和mapper接口中的方法名一致
import pojo.User;

import java.util.List;

public interface UserMapper {
    // 添加用户信息
    int insertUser();

    // 更新用户信息
    void updateUser();

    // 删除用户信息
    void deleteUser();

    // 根据id查询用户信息
    User getUserById();

    // 查询所有用户信息
    List<User> getAllUser();
}
