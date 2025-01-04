<template>
  <div class="sidebar">
    <h1>管理後台</h1>
    <nav>
      <ul>
        <li><router-link to="/">產品列表（包含更新/ 刪除）</router-link></li>
        <li><router-link to="/product/add">新增產品</router-link></li>
      </ul>
    </nav>
  </div>
</template>

<script setup>
</script>

<style scoped>
.sidebar {
  width: 250px;
  background: #f9f9f9;
  padding: 20px;
  border-right: 1px solid #ddd;
  height: 100vh;
}

h1 {
  font-size: 20px;
  color: #333;
  text-align: center;
  margin-bottom: 20px;
}

nav ul {
  list-style: none;
  padding: 0;
}

nav ul li {
  margin-bottom: 15px;
}

nav ul li a {
  text-decoration: none;
  color: #333;
  font-weight: bold;
  transition: color 0.2s;
}

nav ul li a:hover {
  color: #007bff;
}
</style>




