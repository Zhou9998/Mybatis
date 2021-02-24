package com.z1s1c1;

import com.z1s1c1.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取Student数据

        //1.定义mybatis主配置文件的名称,从类路径的根开始(target/classes)
        String config="mybatis.xml";
        //2.读取config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.[重要]获取SqlSession对象，从SqlSessionFactory中获取SqlSession！！！！！！！！！！！！！！！！！！！
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句的标识。sql映射文件中的namespace + "." +标签的id值
        String sqlId = "com.z1s1c1.dao.StudentDao" + "." + "selectStudents";
        //7.[重要]执行sql语句，通过sqlId找到语句！！！！！！！！！！！！！！！！！！！！
        List<Student> students = sqlSession.selectList(sqlId);
        //8.输出结果
        for (Student stu: students) {
            System.out.println(stu);
        }
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
