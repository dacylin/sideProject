<template>
  <div class="product-list">
    <h2>產品列表</h2>
    <div class="products">
      <div
        v-for="product in products"
        :key="product.productsid"
        class="product-card"
        @click="selectProduct(product)"
      >
        <div class="product-image-container">
          <img :src="product.productspic" alt="Product Image" class="product-image" />
        </div>
        <div class="product-info">
          <h3>{{ product.productsname }}</h3>
          <p class="price">NT${{ product.productsprice }}</p>
        </div>
      </div>
    </div>

    <!-- 選中產品模態框 -->
    <div v-if="selectedProduct" class="modal">
      <div class="modal-content">
        <button class="close-btn" @click="closeModal">×</button>
        <h2>{{ selectedProduct.productsname }}</h2>
        <img :src="selectedProduct.productspic" alt="Product Image" class="product-detail-image" />
        <p><strong>價格：</strong>NT${{ selectedProduct.productsprice }}</p>
        <p><strong></strong>{{ selectedProduct.productsdescribe }}</p>
        <div class="modal-actions">
          <router-link :to="`/product/edit/${selectedProduct.productsid}`" class="btn">更新</router-link>
          <router-link :to="`/product/delete/${selectedProduct.productsid}`" class="btn delete-btn">刪除</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

// 產品資料和選中產品
const products = ref([]);
const selectedProduct = ref(null);

// 獲取產品資料
const fetchProducts = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/products");
    products.value = response.data;
  } catch (error) {
    console.error("無法載入產品資料：", error);
  }
};

// 選擇產品
const selectProduct = (product) => {
  selectedProduct.value = product;
};

// 關閉模態框
const closeModal = () => {
  selectedProduct.value = null;
};

onMounted(fetchProducts);
</script>

<style scoped>
.product-list {
  padding: 20px;
}

.products {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: space-around;
}

.product-card {
  display: flex;
  flex-direction: column;
  border: 1px solid #ddd;
  border-radius: 8px;
  width: 300px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background: #fff;
  cursor: pointer;
  transition: transform 0.2s ease-in-out;
}

.product-card:hover {
  transform: scale(1.05);
}

.product-image-container {
  text-align: center;
}

.product-image {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 8px 8px 0 0;
}

.product-info {
  padding: 10px;
  text-align: center;
}

.price {
  font-weight: bold;
  color: #e74c3c;
  margin: 10px 0;
}

/* 模態框樣式 */
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5); /* 背景半透明遮罩 */
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  z-index: 1000;
}

.modal-content {
  background: #fff;
  padding: 20px;
  border-radius: 12px;
  width: 500px;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  text-align: center;
  position: relative;
}

.modal-content img {
  width: 100%;
  max-width: 400px;
  margin-bottom: 20px;
}

.modal-content h2 {
  font-size: 24px;
  margin-bottom: 15px;
}

.modal-content p {
  font-size: 16px;
  margin-bottom: 15px;
}

.modal-actions {
  display: flex;
  justify-content: space-around;
}

.btn {
  padding: 10px 20px;
  background: #007bff;
  color: #fff;
  text-decoration: none;
  border-radius: 4px;
  font-size: 14px;
}

.btn:hover {
  background: #0056b3;
}

.delete-btn {
  background: #e74c3c;
}

.delete-btn:hover {
  background: #c0392b;
}

.close-btn {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 20px;
  cursor: pointer;
}
</style>






