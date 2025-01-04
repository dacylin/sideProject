import { createRouter, createWebHistory } from 'vue-router';
import GetAllProducts from '../modules/products/GetAllProducts.vue';
import AddProduct from '../modules/products/AddProduct.vue';
import UpdateProduct from '../modules/products/UpdateProduct.vue';
import DeleteProduct from '../modules/products/DeleteProduct.vue';

const routes = [
  { path: '/', name: 'Products', component: GetAllProducts },
  { path: '/product/add', name: 'AddProduct', component: AddProduct },
  { path: '/product/edit/:id', name: 'UpdateProduct', component: UpdateProduct },
  { path: '/product/delete/:id', name: 'DeleteProduct', component: DeleteProduct },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;


