package com.z1s1c1.dao;

import com.z1s1c1.domain.Student;

import java.util.List;

public interface OrderDao {
    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);
    //where使用
    List<Student> selectStudentWhere(Student student);
    //foreach 用法1
    List<Student> selectForeachOne(List<Integer> idList);
    //foreach 用法2
    List<Student> selectForeachTwo(List<Student> stuList);
}

