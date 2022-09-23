package 字段和属性映射关系处理;

import mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Emp;
import utils.SqlSessionUtil;

import java.util.List;

public class 使用resultMap处理 {
    @Test
    public void getEmpByEmpId(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        Emp empByEmpId_2 = mapper.getEmpByEmpId_2(1);
        System.out.println(empByEmpId_2);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
