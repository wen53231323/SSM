package 多对一映射关系处理;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.util.List;

public class association处理 {
    @Test
    public void getEmpAndDeptByEmpId(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        Emp empAndDeptByEmpId = mapper.getEmpAndDeptByEmpId_2(1);
        System.out.println(empAndDeptByEmpId);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
