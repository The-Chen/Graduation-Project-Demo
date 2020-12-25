package com.thechen.bishe;

import com.thechen.bishe.pojo.Task;
import com.thechen.bishe.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDateTime;

@SpringBootTest
class BisheApplicationTests {

    @Autowired
    TaskServiceImpl taskService;

    @Test
    void contextLoads() {
        Task task =new Task();
//        task.setId(2);
        task.setAddress("北京");
        task.setDescription("清扫卧室");
        task.setName("李女士");
        task.setPhone("15487964864");
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        task.setTime(date);
        for (int i = 0; i < 20; i++) {
            taskService.addTask(task);
        }

    }

}
