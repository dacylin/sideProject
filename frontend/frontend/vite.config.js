import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  service: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changOrigin: true,
        rewrite:(path)=> path.replace(/^\/api/, '')
      }
    }
  }
  
})
