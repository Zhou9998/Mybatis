package com.z1s1c1;

import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.domain.Student;
import com.z1s1c1.util.MyBatisUtils;
import com.z1s1c1.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        Student student = dao.selectStudentById(1002);
        System.out.println(student);
    }

    @Test
    public void testSelectMulitParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四",20);
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMulitObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("zhangsan");
        queryParam.setParamAge(20);
        List<Student> students = dao.selectMultiObject(queryParam);
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMulitPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiPosition("lisi",30);
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectUse$("lisi");
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectUse$Order("name");
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }
}
