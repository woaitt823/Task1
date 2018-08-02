package com.tt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Cycle {

    @Autowired
    UserMapper userMapper;

    public int add(User user) throws Exception {
        return userMapper.insertUser(user);
    }

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 100; j++) {
                User user = new User();
                try {
                    user.setAddress("修真院");
                    user.setBirthday("2018.07.01");
                    user.setSex("男");
                    user.setUsername("石gay林");
                    userMapper.insertUser(user);
                    System.out.println("插入成功");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("插入失败");
                    throw e;
                }
            }

            long end = System.currentTimeMillis();

            long time = end - start;
            System.out.println(true + "ms");
        }
    }
}