package com.z1s1c1;

import com.github.pagehelper.PageHelper;
import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.domain.Student;
import com.z1s1c1.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(20);
        student.setName("zhangsan");
        List<Student> studentList = dao.selectStudentIf(student);
        for (Student stu:studentList
             ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setAge(20);
        student.setName("zhangsan");
        List<Student> studentList = dao.selectStudentWhere(student);
        for (Student stu:studentList
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testFor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        //String sql = "select * from student where id in (1001,1002,1002)";
        String sql = "SELECT * FROM STUDENT WHERE ID IN ";
        StringBuilder builder = new StringBuilder();
        //添加开始的小括号
        builder.append("(");
        for (Integer i :list){
            builder.append(i).append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(");");
        sql += builder.toString();
        System.out.println(sql);
    }

    @Test
    public void testSelectForeachOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> studentList = dao.selectForeachOne(list);
        for (Student stu:studentList
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectForeachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        list.add(s1);
        s1 = new Student();
        s1.setId(1003);
        list.add(s1);
        List<Student> studentList = dao.selectForeachTwo(list);
        for (Student stu:studentList
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectAllPageHelper(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页
        //pageNum:第几页，从1开始
        //pageSize:一页中有多少行数据
        PageHelper.startPage(1,3);
        List<Student> studentList = dao.selectAll();
        for (Student stu:studentList
        ) {
            System.out.println(stu);
        }
    }
}
