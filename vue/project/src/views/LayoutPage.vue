<template>
  <div class="layout">
    <div class="left">
      <Left />
    </div>
    <div class="right">
      <router-view />
    </div>
  </div>
</template>

<script setup>
import Left from '@/components/LeftPage.vue'
</script>

<style scoped>
.layout {
  width: 100%;
  min-height: 100vh;
  display: flex;
  background: #fff;
}

.left {
  flex-shrink: 0;
  height: 100vh;
  position: sticky;
  top: 0;
}

.right {
  flex: 1;
  min-width: 0;
  overflow: auto;
}
</style>
