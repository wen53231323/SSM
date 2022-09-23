package mapper;


// MyBatis面向接口编程的两个一致
// 映射文件的namespace要和mapper接口的全类名一致
// 映射文件中sql语句的id要和mapper接口中的方法名一致

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // ================================MyBatis的各种查询功能=================================
    // ----------------------查询一个实体类对象----------------------
    // 根据用户id查询用户信息
    User getUserById(@Param("id") int id);

    // ----------------------查询一个List集合----------------------
    // 查询所有用户信息
    List<User> getUserList();

    // ----------------------查询单个数据----------------------
    // 查询用户的总记录数
    int getCount();

    // ----------------------查询一条数据为map集合----------------------
    // 根据用户id查询用户信息为map集合
    Map<String, Object> getUserToMap(@Param("id") int id);

    // ----------------------查询多条数据为map集合----------------------
    // 查询所有用户信息为map集合
    // 方法一：
    // 将表中的数据以map集合的方式查询，一条数据对应一个map；
    // 若有多条数据，就会产生多个map集合，此时可以将这些map放在一个list集合中获取
    List<Map<String, Object>> getAllUserToMap_1();

    // 方法二：
    // 将表中的数据以map集合的方式查询，一条数据对应一个map；
    // 若有多条数据，就会产生多个map集合，并且最终要以一个map的方式返回数据，
    // 此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
    @MapKey("id")
    Map<String, Object> getAllUserToMap_2();

    // ================================MyBatis特殊SQL的执行=================================
    // --------------------------模糊查询---------------------------
    // 根据用户名进行模糊查询
    List<User> getUserByLike(@Param("mohu") String mohu);

    // --------------------------批量删除---------------------------
    // 根据id批量删除
    int deleteMore(@Param("ids") String ids);

    // 动态查询指定表中的数据
    List<User> getUserByTable(@Param("tableName") String tableName);

    // 添加用户信息，获取自增的主键（默认的添加返回值是）
    void insertUser(User user);

}
