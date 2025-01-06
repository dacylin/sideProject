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

    <!-- 小卡彈窗 -->
    <div v-if="selectedProduct" class="modal">
      <div class="modal-content">
        <button class="close-btn" @click="closeModal">×</button>
        <h2>{{ selectedProduct.productsname }}</h2>
        <img :src="selectedProduct.productspic" alt="Product Image" class="product-detail-image" />
        <p><strong>價格：</strong>NT${{ selectedProduct.productsprice }}</p>
        <p><strong>描述：</strong>{{ selectedProduct.productsdescribe }}</p>
        <div class="modal-actions">
         
          <router-link :to="`/product/edit/${selectedProduct.productsid}`" class="btn">
            更新
          </router-link>
         
          <router-link :to="`/product/delete/${selectedProduct.productsid}`" class="btn delete-btn">
            刪除
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

const products = ref([]); // 產品列表
const selectedProduct = ref(null); // 當前選中的產品

// 從後端加載產品數據
const fetchProducts = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/products");
    products.value = response.data;
  } catch (error) {
    console.error("無法載入產品資料:", error);
  }
};

// 選擇產品，打開小卡
const selectProduct = (product) => {
  selectedProduct.value = product;
};

// 關閉小卡
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

.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background: #fff;
  padding: 20px;
  border-radius: 12px;
  width: 500px;
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

