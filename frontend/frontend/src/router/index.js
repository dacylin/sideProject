import { createRouter, createWebHistory } from "vue-router";
import Login from "../modules/Login.vue";
import GetAllProducts from "../modules/products/GetAllProducts.vue";
import AddProduct from "../modules/products/AddProduct.vue";
import GetAllAdmins from "../modules/admins/GetAllAdmins.vue";
import AddAdmin from "../modules/admins/AddAdmin.vue";
import UpdateAdmin from "../modules/admins/UpdateAdmin.vue";
import UpdateProduct from "../modules/products/UpdateProduct.vue"; 
import DeleteProduct from "../modules/products/DeleteProduct.vue"; 

const routes = [
  { path: "/login", name: "Login", component: Login }, 
  { path: "/", name: "Home", redirect: "/login" }, 
  { path: "/products", name: "Products", component: GetAllProducts }, 
  { path: "/product/add", name: "AddProduct", component: AddProduct }, 
  { path: "/admins", name: "Admins", component: GetAllAdmins },
  { path: "/admin/add", name: "AddAdmin", component: AddAdmin }, 
  { path: "/admin/edit/:id", name: "UpdateAdmin", component: UpdateAdmin, props: true }, 
  { path: "/product/edit/:id", name: "EditProduct", component: UpdateProduct, props: true }, 
  { path: "/product/delete/:id", name: "DeleteProduct", component: DeleteProduct, props: true }, 
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// 路由守衛
router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem("admin"); // 檢查是否已登入
  if (to.name !== "Login" && !isAuthenticated) {
    next({ name: "Login" }); // 未登入則跳轉登入頁
  } else {
    next(); // 已登入則允許訪問
  }
});

export default router;



