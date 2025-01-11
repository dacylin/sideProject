import { defineStore } from 'pinia';
import axios from '@/api/axios'; // 確保正確引入 axios 實例
import router from '@/router'; // 確保正確引入 Vue Router

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('token') || null, // 初始化 Token
    user: JSON.parse(localStorage.getItem('user')) || null, // 初始化用戶信息
  }),

  actions: {
    // 登入方法
    async login(username, password) {
      try {
        const response = await axios.post('/auth/login', { username, password });

        // 儲存 Token 和用戶信息
        this.token = response.data.token;
        this.user = { username, role: response.data.role };
        localStorage.setItem('token', this.token);
        localStorage.setItem('user', JSON.stringify(this.user));

        // 跳轉到首頁
        router.push('/');
      } catch (error) {
        console.error(error);
        alert('Invalid username or password'); // 提示錯誤
      }
    },

    // 登出方法
    logout() {
      this.token = null;
      this.user = null;

      // 清除 Local Storage
      localStorage.removeItem('token');
      localStorage.removeItem('user');

      // 跳轉到登入頁面
      router.push('/login');
    },

    // 驗證是否已登入
    isAuthenticated() {
      return !!this.token; // 驗證 Token 是否存在
    },
  },
});
