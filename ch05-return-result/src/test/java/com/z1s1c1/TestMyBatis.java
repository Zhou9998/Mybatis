package com.z1s1c1;

import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.domain.MyStudent;
import com.z1s1c1.domain.Student;
import com.z1s1c1.util.MyBatisUtils;
import com.z1s1c1.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
import java.util.Map;

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
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四",20);
        for (Student student:students ){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectViewStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        ViewStudent student = dao.selectStudentReturnViewStudent(1002);
        System.out.println(student);
    }

    @Test
    public void testSelectCount(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        int student = dao.countStudent();
        System.out.println(student);
    }

    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        Map<Object,Object> student = dao.selectMapById(1001);
        System.out.println(student);
    }

    @Test
    public void testSelectAllStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<Student> student = dao.selectAllStudent();
        for (Student student1: student
             ) {
            System.out.println(student1);
        }
    }

    @Test
    public void testSelectMyStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<MyStudent> student = dao.selectMyStudent();
        for (MyStudent stu: student
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println("dao="+dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<MyStudent> student = dao.selectDiffColProperty();
        for (MyStudent stu: student
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%li%";
        List<Student> student = dao.selectLikeOne(name);
        for (Student stu: student
        ) {
            System.out.println(stu);
        }
    }
    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "li";
        List<Student> student = dao.selectLikeTwo(name);
        for (Student stu: student
        ) {
            System.out.println(stu);
        }
    }
}
