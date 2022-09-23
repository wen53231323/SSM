package 逆向工程MyBatis3尊享版.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import 逆向工程MyBatis3尊享版.pojo.Emp;
import 逆向工程MyBatis3尊享版.pojo.EmpExample;

public interface EmpMapper {
    // 根据条件获取总记录数
    int countByExample(EmpExample example);

    // 根据条件删除
    int deleteByExample(EmpExample example);

    // 根据主键删除
    int deleteByPrimaryKey(Integer empId);

    // 普通插入数据
    int insert(Emp record);

    // 选择性插入：没写的就是null
    int insertSelective(Emp record);

    // 根据条件查询，如果条件为null则查询所有
    List<Emp> selectByExample(EmpExample example);

    // 根据主键查询
    Emp selectByPrimaryKey(Integer empId);

    // 根据条件选择性修改
    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    // 根据条件修改
    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    // 根据主键选择性修改
    int updateByPrimaryKeySelective(Emp record);

    // 根据主键修改
    int updateByPrimaryKey(Emp record);
}