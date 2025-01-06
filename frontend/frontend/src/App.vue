<template>
  <div id="app">
    <Header /> 
    <div class="main-container">
      <Sidebar v-if="showSidebar" /> 
      <div class="content-container">
        <router-view /> 
      </div>
    </div>
    <Footer /> 
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

#app {
  display: flex;
  flex-direction: column;
  height: 100vh;
  margin: 0;
}

.main-container {
  display: flex;
  flex: 1; 
  overflow: hidden;
}


.sidebar {
  width: 250px;
  background-color: #f4f4f4;
  border-right: 1px solid #ddd;
  padding: 20px 0;
  overflow-y: auto; 
}


.content-container {
  flex: 1; 
  overflow-y: auto; 
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


