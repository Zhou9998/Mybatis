package com.z1s1c1.dao.impl;

import com.z1s1c1.dao.StudentDao;
import com.z1s1c1.domain.Student;
import com.z1s1c1.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.z1s1c1.dao.StudentDao.selectStudents";
        //执行sql语句，使用SqlSession类的方法
        List<Student> students = sqlSession.selectList(sqlId);
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.z1s1c1.dao.StudentDao.insertStudent";
        //执行sql语句，使用SqlSession类的方法
        int num = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
