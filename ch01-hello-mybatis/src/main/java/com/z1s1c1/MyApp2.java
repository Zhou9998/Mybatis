package com.z1s1c1;

import com.z1s1c1.domain.Student;
import com.z1s1c1.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取Student数据
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //指定要执行的sql语句的标识。sql映射文件中的namespace + "." +标签的id值
        String sqlId = "com.z1s1c1.dao.StudentDao" + "." + "selectStudents";
        //[重要]执行sql语句，通过sqlId找到语句！！！！！！！！！！！！！！！！！！！！
        List<Student> students = sqlSession.selectList(sqlId);
        //输出结果
        for (Student stu: students) {
            System.out.println(stu);
        }
        //关闭SqlSession对象
        sqlSession.close();
    }
}
