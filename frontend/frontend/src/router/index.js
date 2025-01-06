import { createRouter, createWebHistory } from "vue-router";
import Login from "../modules/Login.vue";
import GetAllProducts from "../modules/products/GetAllProducts.vue";
import AddProduct from "../modules/products/AddProduct.vue";
import GetAllAdmins from "../modules/admins/GetAllAdmins.vue";
import AddAdmin from "../modules/admins/AddAdmin.vue";
import UpdateAdmin from "../modules/admins/UpdateAdmin.vue";
import UpdateProduct from "../modules/products/UpdateProduct.vue"; // 修改點: 新增導入更新頁面
import DeleteProduct from "../modules/products/DeleteProduct.vue"; // 修改點: 新增導入刪除頁面

const routes = [
  { path: "/login", name: "Login", component: Login }, // 登入頁
  { path: "/", name: "Home", redirect: "/login" }, // 首頁重定向到登入頁
  { path: "/products", name: "Products", component: GetAllProducts }, // 商品列表頁
  { path: "/product/add", name: "AddProduct", component: AddProduct }, // 新增商品頁
  { path: "/admins", name: "Admins", component: GetAllAdmins }, // 管理者列表頁
  { path: "/admin/add", name: "AddAdmin", component: AddAdmin }, // 新增管理者頁
  { path: "/admin/edit/:id", name: "UpdateAdmin", component: UpdateAdmin, props: true }, // 更新管理者頁
  { path: "/product/edit/:id", name: "EditProduct", component: UpdateProduct, props: true }, // 修改點: 新增更新商品頁面
  { path: "/product/delete/:id", name: "DeleteProduct", component: DeleteProduct, props: true }, // 修改點: 新增刪除商品頁面
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



