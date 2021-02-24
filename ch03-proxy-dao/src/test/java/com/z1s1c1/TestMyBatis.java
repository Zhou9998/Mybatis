package com.z1s1c1;

import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.domain.Student;
import com.z1s1c1.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){
        /*
        * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对应的实现类对象
        * */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student stu:students) {
            System.out.println("学生="+stu);
        }
    }
    @Test
    public void insertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao="+dao.getClass().getName());
        Student student = new Student();
        student.setId(1007);
        student.setName("韩信");
        student.setEmail("hanxin@163.com");
        student.setAge(24);
        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(num);
    }
}
