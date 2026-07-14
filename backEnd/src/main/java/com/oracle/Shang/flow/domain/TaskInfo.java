package com.oracle.Shang.flow.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 任务表
 * @TableName task_info
 */
@TableName(value ="task_info")
@Data
public class TaskInfo {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 所属项目ID
     */
    private Long projectId;

    /**
     * 父任务ID
     */
    private Long parentId;

    /**
     * 任务标题
     */
    private String title;

    /**
     * 任务说明
     */
    private String description;

    /**
     * 负责人ID
     */
    private Long assigneeId;

    /**
     * 创建人ID
     */
    private Long creatorId;

    /**
     * 任务状态
     */
    private String status;

    /**
     * 优先级
     */
    private String priority;

    /**
     * 截止日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dueDate;

    /**
     * 千问建议
     */
    private String aiSuggestion;

    /**
     * 创建时间
     */
    private Date createTime;
    @TableLogic
    private Integer deleted;

}