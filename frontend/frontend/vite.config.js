import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from "path"

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'), // 設置路徑別名
    },
  },
  server: {
    port: 5173, // 固定伺服器端口為 5173
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 後端 API 的地址
        changeOrigin: true, // 虛擬主機站點需要更改 origin
        rewrite: (path) => path.replace(/^\/api/, '') // 將 /api 替換為空
      }
    }
  }
})

