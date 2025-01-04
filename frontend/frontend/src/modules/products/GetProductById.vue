<template>
    <div>
      <h2>產品詳情</h2>
      <p><strong>名稱:</strong> {{ product.name }}</p>
      <p><strong>價格:</strong> {{ product.price }}</p>
      <p><strong>描述:</strong> {{ product.description }}</p>
      <router-link to="/">返回列表</router-link>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  import axios from 'axios';
  
  const route = useRoute();
  const product = ref({});
  
  const fetchProductById = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/products/${route.params.id}`);
      product.value = response.data;
    } catch (error) {
      console.error('Error fetching product by ID:', error);
    }
  };
  
  onMounted(fetchProductById);
  </script>
  