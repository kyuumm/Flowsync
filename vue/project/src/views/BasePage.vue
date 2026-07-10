<template>
  <div class="page">
    <PageHeader :title="title" :subtitle="subtitle" />
    <div class="page-content">
      <slot />
    </div>
  </div>
</template>

<script setup>
import PageHeader from '@/components/PageHeader.vue'

defineProps({
  title: { type: String, required: true },
  subtitle: { type: String, default: '' }
})
</script>

<style scoped>
.page {
  min-height: 100%;
  display: flex;
  flex-direction: column;
}

.page-content {
  flex: 1;
  padding: 24px 32px;
  background: #f3f4f6;
}
</style>
