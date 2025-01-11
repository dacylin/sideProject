<template>
  <div>
    <h1>Products Management</h1>
    <ul>
      <li v-for="product in store.products" :key="product.id">
        {{ product.name }} - {{ product.price }} - Stock: {{ product.stock }}
        <button @click="store.deleteProduct(product.id)">Delete</button>
      </li>
    </ul>

    <h2>Add Product</h2>
    <form @submit.prevent="addProduct">
      <input v-model="newProduct.name" placeholder="Product Name" required />
      <input v-model="newProduct.price" type="number" placeholder="Price" required />
      <input v-model="newProduct.stock" type="number" placeholder="Stock" required />
      <button type="submit">Add Product</button>
    </form>
  </div>
</template>


<script setup>
import { useMainStore } from '../stores/mainStore';
import { onMounted, ref } from 'vue';

const store = useMainStore();
const newProduct = ref({ name: '', price: 0, stock: 0 });

onMounted(() => {
  store.fetchProducts();
});

const addProduct = async () => {
  if (newProduct.value.name && newProduct.value.price > 0) {
    await store.addProduct(newProduct.value); // 假設 Pinia 中有 `addProduct` 方法
    newProduct.value = { name: '', price: 0, stock: 0 }; // 重置表單
    store.fetchProducts(); // 刷新列表
  }
};
</script>



<style>
form {
  margin-top: 20px;
}
</style>

