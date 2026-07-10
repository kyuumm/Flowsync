<template>
  <div class="page-header">
    <div class="header-left">
      <h1 class="page-title">{{ title }}</h1>
      <p class="page-subtitle">{{ subtitle }}</p>
    </div>
    <div class="header-right">
      <div class="user-info">
        <span class="user-role">项目负责人</span>
        <span class="user-date">{{ today }}</span>
      </div>
      <el-button @click="refreshData">刷新数据</el-button>
      <el-button type="danger" plain @click="logout">退出登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PageHeader',
  props: {
    title: { type: String, required: true },
    subtitle: { type: String, default: '' }
  },
  data() {
    return {
      today: '2026-07-09'
    }
  },
  methods: {
    refreshData() {
      // 假数据刷新，实际项目可在此调用接口
    },
    logout() {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>
.page-header {
  background: #fff;
  padding: 16px 32px;
  border-bottom: 1px solid #e5e7eb;
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  flex-shrink: 0;
}

.page-title {
  font-size: 28px;
  font-weight: 700;
  color: #111827;
  margin-bottom: 6px;
}

.page-subtitle {
  font-size: 14px;
  color: #6b7280;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 12px;
}

.user-info {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  margin-right: 8px;
}

.user-role {
  font-size: 14px;
  font-weight: 600;
  color: #374151;
}

.user-date {
  font-size: 13px;
  color: #9ca3af;
}
</style>
