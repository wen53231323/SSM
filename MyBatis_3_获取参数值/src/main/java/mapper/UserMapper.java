package mapper;


// MyBatis面向接口编程的两个一致
// 映射文件的namespace要和mapper接口的全类名一致
// 映射文件中sql语句的id要和mapper接口中的方法名一致

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // -----------------单个字面量类型的参数-----------------
    // 根据用户名查询用户信息（#{}方式）
    User getUserByUsername_1(String username);

    // 根据用户名查询用户信息（${}方式）
    User getUserByUsername_2(String username);

    // -----------------多个字面量类型的参数-----------------
    // 用户验证登录（#{}方式，age0,age1,...获取）
    User checklogin_1(String username, String password);

    // 用户验证登录（${}方式，param1,param2,...获取）
    User checklogin_2(String username, String password);

    // -----------------map集合类型的参数-----------------
    // 用户验证登录
    User checkloginByMap(Map<String, Object> map);

    // -----------------实体类类型的参数-----------------
    // 添加用户信息
    void insertUser(User user);

    // -----------------使用@Param注解标识参数-----------------
    // 用户验证登录
    User checkloginByParam(@Param("username") String username, @Param("password") String password);

}
