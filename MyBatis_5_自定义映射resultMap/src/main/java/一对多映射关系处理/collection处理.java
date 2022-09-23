package 一对多映射关系处理;

import mapper.DeptMapper;
import mapper.EmpMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Dept;
import pojo.Emp;
import utils.SqlSessionUtil;

public class collection处理 {
    @Test
    public void getDeptAndEmpByDeptId(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);


        // 使用实现类对象，调用Mapper接口的方法
        Dept deptAndEmpByDeptId = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(deptAndEmpByDeptId);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
