<template>
  <div class="layout">
    <Header />
    <div class="main-content">
      <Sidebar />
      <router-view class="content" />
    </div>
    <Footer />
  </div>
</template>

<script setup>
import Header from './layout/Header.vue';
import Sidebar from './layout/Sidebar.vue';
import Footer from './layout/Footer.vue';
</script>

<style scoped>
.layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-content {
  display: flex;
  flex: 1;
}

.content {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
}
</style>

