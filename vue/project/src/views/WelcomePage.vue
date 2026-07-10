<template>
  <div class="page">
    <PageHeader title="总览" subtitle="查看系统整体情况与最近动态" />

    <div class="page-body">
      <div class="stats-row">
        <div v-for="item in stats" :key="item.label" class="stat-card">
          <div class="stat-label">{{ item.label }}</div>
          <div class="stat-value">{{ item.value }}</div>
        </div>
      </div>

      <div class="tables-row">
        <div class="table-card">
          <div class="table-title">最近项目</div>
          <el-table :data="recentProjects" stripe style="width: 100%">
            <el-table-column prop="name" label="项目名称" min-width="160" />
            <el-table-column prop="status" label="状态" width="100">
              <template #default="{ row }">
                <el-tag :type="statusTagType(row.status)" size="small">{{ row.status }}</el-tag>
              </template>
            </el-table-column>
            <el-table-column prop="priority" label="优先级" width="90">
              <template #default="{ row }">
                <el-tag :type="priorityTagType(row.priority)" size="small" effect="plain">
                  {{ row.priority }}
                </el-tag>
              </template>
            </el-table-column>
          </el-table>
        </div>

        <div class="table-card">
          <div class="table-title">最近任务</div>
          <el-table :data="recentTasks" stripe style="width: 100%">
            <el-table-column prop="title" label="任务标题" min-width="160" />
            <el-table-column prop="status" label="状态" width="100">
              <template #default="{ row }">
                <el-tag :type="statusTagType(row.status)" size="small">{{ row.status }}</el-tag>
              </template>
            </el-table-column>
            <el-table-column prop="priority" label="优先级" width="90">
              <template #default="{ row }">
                <el-tag :type="priorityTagType(row.priority)" size="small" effect="plain">
                  {{ row.priority }}
                </el-tag>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import PageHeader from '@/components/PageHeader.vue'
import { statusTagType, priorityTagType } from '@/utils/tags'

const stats = ref([
  { label: '成员总数', value: 3 },
  { label: '项目总数', value: 2 },
  { label: '任务总数', value: 16 },
  { label: '总结总数', value: 0 }
])

const recentProjects = ref([
  { name: '课程答辩准备项目', status: '未开始', priority: '中' },
  { name: '迎新活动协同项目', status: '进行中', priority: '高' }
])

const recentTasks = ref([
  { title: '检查设备与环境', status: '未开始', priority: '中' },
  { title: '准备问答预测材料', status: '未开始', priority: '中' },
  { title: '模拟答辩演练', status: '未开始', priority: '高' },
  { title: '撰写答辩讲稿', status: '未开始', priority: '高' },
  { title: '整理答辩PPT', status: '未开始', priority: '高' }
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

.stats-row {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 16px;
  margin-bottom: 20px;
}

.stat-card {
  background: #fff;
  border-radius: 12px;
  padding: 20px 24px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.stat-label {
  font-size: 14px;
  color: #6b7280;
  margin-bottom: 10px;
}

.stat-value {
  font-size: 32px;
  font-weight: 700;
  color: #111827;
}

.tables-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
}

.table-card {
  background: #fff;
  border-radius: 12px;
  padding: 20px 24px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.table-title {
  font-size: 16px;
  font-weight: 600;
  color: #111827;
  margin-bottom: 16px;
}
</style>
