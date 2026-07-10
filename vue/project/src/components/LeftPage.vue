<template>
  <div class="sidebar">
    <div class="brand">
      <div class="brand-name">FlowSync</div>
      <div class="brand-sub">小组任务协同</div>
    </div>

    <el-menu
      mode="vertical"
      :default-active="activeMenu"
      router
      class="sidebar-menu"
    >
      <el-menu-item-group title="工作台">
        <el-menu-item index="/layout">
          <el-icon><House /></el-icon>
          <span>总览</span>
        </el-menu-item>
      </el-menu-item-group>

      <el-menu-item-group title="业务管理">
        <el-menu-item index="/layout/project">
          <el-icon><Folder /></el-icon>
          <span>项目管理</span>
        </el-menu-item>
        <el-menu-item index="/layout/decompose">
          <el-icon><Operation /></el-icon>
          <span>任务拆解</span>
        </el-menu-item>
        <el-menu-item index="/layout/task">
          <el-icon><List /></el-icon>
          <span>任务管理</span>
        </el-menu-item>
        <el-menu-item index="/layout/progress">
          <el-icon><TrendCharts /></el-icon>
          <span>进度跟踪</span>
        </el-menu-item>
        <el-menu-item index="/layout/summary">
          <el-icon><Document /></el-icon>
          <span>总结中心</span>
        </el-menu-item>
      </el-menu-item-group>

      <el-menu-item-group title="系统信息">
        <el-menu-item index="/layout/members">
          <el-icon><User /></el-icon>
          <span>成员列表</span>
        </el-menu-item>
        <el-menu-item index="/layout/profile">
          <el-icon><UserFilled /></el-icon>
          <span>个人信息</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-menu>
  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import {
  House,
  Folder,
  Operation,
  List,
  TrendCharts,
  Document,
  User,
  UserFilled
} from '@element-plus/icons-vue'

const route = useRoute()
const activeMenu = computed(() => route.path)
</script>

<style scoped>
.sidebar {
  width: 220px;
  height: 100%;
  background: #fff;
  border-right: 1px solid #e5e7eb;
  display: flex;
  flex-direction: column;
}

.brand {
  padding: 24px 20px 19px;
  /* border-bottom: 1px solid #e8eaed; */
}

.brand-name {
  font-size: 22px;
  font-weight: 700;
  color: #1f2937;
}

.brand-sub {
  margin-top: 4px;
  font-size: 13px;
  color: #9ca3af;
}

.sidebar-menu {
  border-right: none;
  flex: 1;
}

.sidebar-menu :deep(.el-menu-item-group__title) {
  padding-left: 20px;
  color: #9ca3af;
  font-size: 12px;
}

.sidebar-menu :deep(.el-menu-item) {
  height: 44px;
  line-height: 44px;
  margin: 2px 8px;
  border-radius: 8px;
}

.sidebar-menu :deep(.el-menu-item.is-active) {
  background: #eff6ff;
  color: #2563eb;
  position: relative;
}

.sidebar-menu :deep(.el-menu-item.is-active)::after {
  content: '';
  position: absolute;
  right: 0;
  top: 8px;
  bottom: 8px;
  width: 3px;
  background: #2563eb;
  border-radius: 2px;
}
</style>
