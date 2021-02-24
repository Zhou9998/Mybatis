package com.z1s1c1;

import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.dao.impl.StudentDaoImpl;
import com.z1s1c1.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){
        //com.z1s1c1.dao.StudentDao
        StudentDao dao = new StudentDaoImpl();
        /*
        * List<Student> studentList = dao.selectStudents();//调用
        * 1.dao对象，类型是StudentDao，全限定名称是：com.z1s1c1.dao.StudentDao，全限定名称和namespace是一样的。
        * 2.方法名称，selectStudents就是mapper文件中的id值
        * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法。
        *    如果返回值是List，调用的是SqlSession.selectList()方法；
        *    如果返回值是int，或是非list的，看mapper文件中的标签是<insert>还是<update>,就会调用SqlSession的insert,update方法
        *
        * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息;mybatis根据dao接口，
        *                   创建出一个dao接口的实现类，并创建这个类的对象。完成SqlSession调用方法，访问数据库
        * */
        List<Student> studentList = dao.selectStudents();
        for (Student stu: studentList) {
            System.out.println(stu);
        }
    }
    @Test
    public void insertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1006);
        student.setName("娜可露露");
        student.setEmail("nakelulu@163.com");
        student.setAge(16);
        int num = dao.insertStudent(student);
        System.out.println(num);
    }
}
