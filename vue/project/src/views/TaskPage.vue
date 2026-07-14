<template>
  <div class="page">
    <PageHeader title="任务管理" subtitle="维护任务、负责人、状态与截止时间" />

    <div class="page-body">
      <div class="content-card">
        <div class="card-header">
          <span class="card-title">任务列表</span>
          <el-button type="primary" @click="load()">加载</el-button>
          <el-button type="primary">+ 新建任务</el-button>
        </div>

        <el-table :data="tasks" stripe style="width: 100%">
          <el-table-column prop="title" label="任务标题" min-width="140" />
          <el-table-column prop="project" label="所属项目" min-width="150" />
          <el-table-column prop="owner" label="负责人" width="110" />
          <el-table-column prop="status" label="状态" width="90">
            <template #default="{ row }">
              <el-tag :type="statusTagType(row.status)" size="small">{{ row.status }}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="priority" label="优先级" width="80">
            <template #default="{ row }">
              <el-tag :type="priorityTagType(row.priority)" size="small" effect="plain">
                {{ row.priority }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="deadline" label="截止日期" width="110" />
          <el-table-column prop="description" label="任务说明" min-width="200" show-overflow-tooltip />
          <el-table-column label="操作" width="120" fixed="right">
            <template #default>
              <el-button link type="primary">编辑</el-button>
              <el-button link type="danger">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import PageHeader from '@/components/PageHeader.vue'
import { statusTagType, priorityTagType } from '@/utils/tags'



const tasks = ref([
  {
    title: 'qwqwqw',
    project: '课程答辩准备项目',
    owner: '项目负责人',
    status: '未开始',
    priority: '中',
    deadline: '2026-07-09',
    description: 'qweq'
  },
  {
    title: 'qwqwqw',
    project: '迎新活动协同项目',
    owner: '项目负责人',
    status: '未开始',
    priority: '高',
    deadline: '2026-07-15',
    description: '123123'
  },
  {
    title: '准备问答预测材料',
    project: '课程答辩准备项目',
    owner: '张三',
    status: '未开始',
    priority: '中',
    deadline: '2024-07-12',
    description: '梳理常见答辩问题，准备参考回答'
  },
  {
    title: '模拟答辩演练',
    project: '课程答辩准备项目',
    owner: '李四',
    status: '未开始',
    priority: '高',
    deadline: '2024-07-13',
    description: '组织一次完整模拟答辩'
  },
  {
    title: '撰写答辩讲稿',
    project: '课程答辩准备项目',
    owner: '项目负责人',
    status: '未开始',
    priority: '高',
    deadline: '2024-07-14',
    description: '根据PPT撰写完整讲稿'
  },
  {
    title: '整理答辩PPT',
    project: '课程答辩准备项目',
    owner: '李四',
    status: '未开始',
    priority: '高',
    deadline: '2024-07-15',
    description: '整理答辩PPT内容并统一样式'
  },
  {
    title: '检查设备与环境',
    project: '课程答辩准备项目',
    owner: '张三',
    status: '未开始',
    priority: '中',
    deadline: '2024-07-16',
    description: '提前检查电脑、投影、网络，预装演示环境'
  },
  {
    title: '明确分工',
    project: '迎新活动协同项目',
    owner: '张三',
    status: '进行中',
    priority: '高',
    deadline: '2024-07-09',
    description: '梳理活动所需岗位并明确各自职责'
  },
  {
    title: '确定活动主题',
    project: '迎新活动协同项目',
    owner: '项目负责人',
    status: '未开始',
    priority: '高',
    deadline: '2024-07-10',
    description: '明确迎新活动主题'
  },
  {
    title: '场地申请',
    project: '迎新活动协同项目',
    owner: '张三',
    status: '未开始',
    priority: '中',
    deadline: '2024-07-11',
    description: '向学校申请活动场地并确认审批节点'
  }
])
</script>

<style scoped>
.page {
  min-height: 100%;
  display: flex;
  flex-direction: column;
}

.page-body {
  flex: 1;
  padding: 24px 32px;
  background: #f3f4f6;
}

.content-card {
  background: #fff;
  border-radius: 12px;
  padding: 20px 24px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}

.card-title {
  font-size: 16px;
  font-weight: 600;
  color: #111827;
}
</style>
