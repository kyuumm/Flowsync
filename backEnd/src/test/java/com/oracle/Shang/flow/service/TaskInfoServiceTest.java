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

    @Test
    public void testSave(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setProjectId(1L);
        taskInfo.setTitle("测试标题");
        taskInfo.setPriority("高");
        taskInfo.setStatus("未开始");
        taskInfoService.save(taskInfo);
    }

    @Test
    public void testDelete(){
        taskInfoService.removeById(51L);
    }

    @Test
    public void testDetails(){
        TaskInfo taskInfo=taskInfoService.getById(50L);
        System.out.println(taskInfo);
    }
    @Test
    public void testUpdate(){
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setId(50L);
        taskInfo.setProjectId(1L);
        taskInfo.setTitle("我要下课");
        taskInfoService.updateById(taskInfo);

    }
}
