<template>
  <div class="page">
    <PageHeader :title="title" :subtitle="subtitle" />
    <div class="page-body">
      <div class="content-card">
        <p class="placeholder">页面开发中</p>
      </div>
    </div>
  </div>
</template>

<script>
import PageHeader from '@/components/PageHeader.vue'

export default {
  name: 'EmptyPage',
  components: { PageHeader },
  props: {
    title: { type: String, required: true },
    subtitle: { type: String, default: '' }
  }
}
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
  padding: 32px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.06);
}

.placeholder {
  color: #9ca3af;
  font-size: 14px;
}
</style>
