<template>
  <div id="app">
    <Header /> <!-- 全局 Header -->
    <div class="main-container">
      <Sidebar v-if="showSidebar" /> <!-- 左側導航 -->
      <div class="content-container">
        <router-view /> <!-- 路由對應的內容頁 -->
      </div>
    </div>
    <Footer /> <!-- 全局 Footer -->
  </div>
</template>

<script setup>
import { computed } from "vue";
import { useRoute } from "vue-router";
import Header from "./components/Header.vue";
import Sidebar from "./components/Sidebar.vue";
import Footer from "./components/Footer.vue";

// 控制是否顯示 Sidebar
const route = useRoute();
const showSidebar = computed(() => route.name !== "Login"); // 僅非登入頁顯示 Sidebar
</script>

<style>
/* 全局樣式 */
#app {
  display: flex;
  flex-direction: column;
  height: 100vh;
  margin: 0;
}

/* 主容器，包含 Sidebar 和內容區域 */
.main-container {
  display: flex;
  flex: 1; /* 撑满剩余高度 */
  overflow: hidden;
}

/* Sidebar 的樣式 */
.sidebar {
  width: 250px;
  background-color: #f4f4f4;
  border-right: 1px solid #ddd;
  padding: 20px 0;
  overflow-y: auto; /* 防止內容過多時溢出 */
}

/* 內容區域樣式 */
.content-container {
  flex: 1; /* 讓內容區域自適應剩餘寬度 */
  overflow-y: auto; /* 防止內容過多時溢出 */
  padding: 20px;
  background-color: #fff;
}

/* Header 樣式 */
.header {
  background-color: #333;
  color: white;
  padding: 10px 20px;
  text-align: center;
}

/* Footer 樣式 */
.footer {
  background-color: #333;
  color: white;
  padding: 10px 20px;
  text-align: center;
}
</style>


