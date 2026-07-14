package com.oracle.Shang.flow.web;

import com.oracle.Shang.flow.domain.TaskInfo;
import com.oracle.Shang.flow.service.TaskInfoService;
import hgc.flowsyncapi.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskInfoService taskInfoService;

    @PostMapping("/save")
    public ApiResponse save(@RequestBody TaskInfo taskInfo) {
        taskInfoService.save(taskInfo);
        return ApiResponse.ok("添加成功");
    }

    @PostMapping("/update")
    public ApiResponse update(@RequestBody TaskInfo taskInfo) {
        taskInfoService.updateById(taskInfo);
        return ApiResponse.ok("修改成功");
    }

    @PostMapping("/list")
    public ApiResponse list() {
        List<TaskInfo> list = taskInfoService.list();
        return ApiResponse.ok(list);
    }

    @GetMapping("/details/{id}")
    public ApiResponse details(@PathVariable("id") Long id) {
        TaskInfo taskInfo = taskInfoService.getById(id);
        return ApiResponse.ok(taskInfo);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable("id") Long id) {
        boolean success = taskInfoService.removeById(id);
        if (success) {
            return ApiResponse.ok("删除成功");
        } else {
            return ApiResponse.fail("删除失败，任务不存在");
        }
    }
}