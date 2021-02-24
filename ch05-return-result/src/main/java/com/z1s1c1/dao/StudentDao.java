package com.z1s1c1.dao;

import com.z1s1c1.domain.MyStudent;
import com.z1s1c1.domain.Student;
import com.z1s1c1.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    Student selectStudentById(@Param("studentId") Integer id);

    List<Student> selectMultiParam(@Param("myName") String name,
                                   @Param("myAge") Integer age);
    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

     int countStudent();

     //定义方法返回map
    Map<Object,Object> selectMapById(@Param("stuId") Integer id);

    /*
    *   使用resultMap定义映射关系
    * */
    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    List<Student> selectLikeOne(String name);

    /*name就是李值，在mapper中拼接like %李%*/
    List<Student> selectLikeTwo(String name);
}

