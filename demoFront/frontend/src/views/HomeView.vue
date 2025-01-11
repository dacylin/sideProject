<template>
  <div>
    <h1>Welcome to the Management System</h1>
    <nav>
      <router-link v-if="user && user.role === 'admin'" to="/admins">Admins Management</router-link> |
      <router-link v-if="user && user.role === 'customer'" to="/customers">Customers Management</router-link> |
      <router-link to="/products">Products Management</router-link>
    </nav>
    <div v-if="user">
      <p>Logged in as: ({{ user.role }})</p>
      <button @click="handleLogout">Logout</button>
    </div>
    <div v-else>
      <p>You are not logged in.</p>
      <router-link to="/login">Login</router-link>
    </div>
  </div>
</template>


<script setup>
import { useUserStore } from '@/stores/userStore';

const userStore = useUserStore();
const user = userStore.user;

const handleLogout = () => {
  userStore.logout();
  router.push('/login'); // 跳轉到登入頁面
};
</script>
