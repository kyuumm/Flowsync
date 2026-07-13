package com.oracle.Shang.flow.service;

import com.oracle.Shang.flow.domain.TaskInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 类：TaskInfoServiceTest
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-13 11:20:27
 */
@SpringBootTest
public class TaskInfoServiceTest {
    @Autowired
    private TaskInfoService taskInfoService;
    @Test
    public void testList()
    {
        List<TaskInfo> list = taskInfoService.list();
        list.forEach(System.out::println);
    }
}
