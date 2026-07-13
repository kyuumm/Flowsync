package com.oracle.Shang.flow.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oracle.Shang.flow.domain.TaskInfo;
import com.oracle.Shang.flow.service.TaskInfoService;
import com.oracle.Shang.flow.mapper.TaskInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author kyuu
* @description 针对表【task_info(任务表)】的数据库操作Service实现
* @createDate 2026-07-13 11:07:31
*/
@Service
public class TaskInfoServiceImpl extends ServiceImpl<TaskInfoMapper, TaskInfo>
    implements TaskInfoService{

}




