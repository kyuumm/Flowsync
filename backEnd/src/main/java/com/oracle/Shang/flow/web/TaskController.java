package com.oracle.Shang.flow.web;

import com.oracle.Shang.flow.domain.TaskInfo;
import com.oracle.Shang.flow.service.TaskInfoService;
import hgc.flowsyncapi.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类：TaskController
 * 描述：TODO
 *
 * @author Shang
 * @version 1.0
 * @date 2026-07-13 11:42:21
 */
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
        List<TaskInfo> list=taskInfoService.list();
        return ApiResponse.ok(list);
    }
    @GetMapping("/details/{id}")
    public ApiResponse details(@PathVariable("id") String id) {
        TaskInfo taskInfo=taskInfoService.getById(50L);
        return ApiResponse.ok(taskInfo);
    }
    @GetMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable("id") String id) {
        boolean t=taskInfoService.removeById(id);
        return ApiResponse.ok("success!");
    }

}
