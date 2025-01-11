import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/views/HomeView.vue';
import AdminsView from '@/views/AdminsView.vue';
import CustomersView from '@/views/CustomersView.vue';
import ProductsView from '@/views/ProductsView.vue';
import LoginView from '@/views/LoginView.vue';
import Unauthorized from '@/views/UnauthorizedView.vue';
import { useUserStore } from '@/stores/userStore';

const routes = [
  { path: '/', name: 'Home', component: HomeView },
  { path: '/login', name: 'Login', component: LoginView },
  { path: '/admins', name: 'Admins', component: AdminsView, meta: { requiresAuth: true, role: 'admin' } },
  { path: '/customers', name: 'Customers', component: CustomersView, meta: { requiresAuth: true, role: 'customer' } },
  { path: '/products', name: 'Products', component: ProductsView, meta: { requiresAuth: true } },
  { path: '/unauthorized', name: 'Unauthorized', component: Unauthorized }, // 新增無權限頁面
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 抽取的路由守衛邏輯
const checkAuth = (to, userStore) => {
  if (!userStore.token) {
    // 未登入，重定向到登入頁面
    return { name: 'Login' };
  }
  if (to.meta.role && to.meta.role !== userStore.user.role) {
    // 無權限訪問
    return { name: 'Unauthorized' }; // 重定向到無權限頁面
  }
  return true; // 通過驗證
};

// 路由守衛
router.beforeEach((to, from, next) => {
  const userStore = useUserStore();
  if (to.meta.requiresAuth) {
    const result = checkAuth(to, userStore);
    if (result === true) next(); // 通過驗證，放行
    else next(result); // 重定向或阻止導航
  } else {
    next(); // 無需驗證，放行
  }
});

export default router;

