<template>
  <div class="sidebar">
    <ul>
      <li><router-link to="/products">商品管理 - 查看商品列表</router-link></li>
      <li><router-link to="/product/add">商品管理 - 新增商品</router-link></li>
      <li><router-link to="/admins">管理者管理 - 查看管理者列表</router-link></li>
      <li><router-link to="/admin/add">管理者管理 - 新增管理者</router-link></li>
    </ul>
  </div>
</template>

<script setup>
</script>

<style>
.sidebar ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.sidebar ul li {
  margin: 10px 0;
}

.sidebar ul li a {
  text-decoration: none;
  color: #333;
  display: block;
  padding: 10px;
  border-radius: 4px;
  transition: background-color 0.3s;
}

.sidebar ul li a:hover {
  background-color: #ddd;
}
</style>
