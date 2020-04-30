package com.crt.vhr;

import com.crt.vhr.mapper.EmployeeMapper;
import com.crt.vhr.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class Vhr04ApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;


    @Autowired
    EmployeeService employeeService;

    @Test
    void contextLoads() {
        System.out.println(employeeService.getMaxWorkId());
    }

    @Test
    void test01(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");

        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println("date为："+simpleDateFormat.format(date));
        long time = date.getTime();
        System.out.println(time);

    }

    @Test
    void test02(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
        Date date = new Date();
        Integer integer = Integer.valueOf(simpleDateFormat.format(date).toString());
        System.out.println(integer);
    }

}
