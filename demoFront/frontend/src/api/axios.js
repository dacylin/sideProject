import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api', // 後端地址
  headers: {
    'Content-Type': 'application/json',
  },
});

// 攔截請求，檢查是否攜帶 Token
apiClient.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default apiClient;

