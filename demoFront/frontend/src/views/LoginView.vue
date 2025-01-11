<template>
  <div>
    <h1>Login</h1>
    <form @submit.prevent="handleLogin">
      <label>Username: <input v-model="username" /></label><br />
      <label>Password: <input type="password" v-model="password" /></label><br />
      <button type="submit">Login</button>
    </form>
    <p v-if="error">{{ error }}</p>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/userStore';

const username = ref('');
const password = ref('');
const error = ref(null);

const router = useRouter();
const userStore = useUserStore();

const handleLogin = async () => {
  const success = await userStore.login(username.value, password.value);
  if (success) {
    router.push('/'); // 登入成功後跳轉
  } else {
    error.value = 'Invalid username or password';
  }
};
</script>



<style>
/* 可根據需要美化樣式 */
</style>
