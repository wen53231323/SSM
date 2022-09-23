package 一对多映射关系处理;

import mapper.DeptMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Dept;
import utils.SqlSessionUtil;

public class 分步查询 {
    @Test
    public void getDeptAndEmpByDeptId(){
        // 调用工具类SqlSessionUtil中的静态方法静态方法getSqlSession()，获取MyBatis提供的操作数据库的会话对象SqlSession
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // 获取UserMapper的代理实现类对象
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);

        // 使用实现类对象，调用Mapper接口的方法
        Dept deptAndEmpByStep_1 = mapper.getDeptAndEmpByStep_1(1);
        System.out.println(deptAndEmpByStep_1);

        // 关闭sqlSession对象
        sqlSession.close();
    }
}
