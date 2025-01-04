<template>
  <div class="product-form">
    <h2>更新產品</h2>
    <form @submit.prevent="updateProduct">
      <div class="form-group">
        <label for="productsname">產品名稱</label>
        <input
          type="text"
          id="productsname"
          v-model="product.productsname"
          required
        />
      </div>
      <div class="form-group">
        <label for="productsprice">價格</label>
        <input
          type="number"
          id="productsprice"
          v-model="product.productsprice"
          required
          min="1"
        />
      </div>
      <div class="form-group">
        <label for="productsdescribe">描述</label>
        <textarea
          id="productsdescribe"
          v-model="product.productsdescribe"
          required
        ></textarea>
      </div>
      <div class="form-group">
        <label for="productspic">圖片網址</label>
        <input
          type="url"
          id="productspic"
          v-model="product.productspic"
          required
        />
      </div>
      <button type="submit" class="submit-btn">更新產品</button>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

// 路由
const route = useRoute();
const router = useRouter();
const productId = route.params.id;

// 產品資料
const product = ref({
  productsname: "",
  productsprice: null,
  productsdescribe: "",
  productspic: "",
});

// 獲取產品資料
const fetchProduct = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/products/${productId}`);
    product.value = response.data;
  } catch (error) {
    console.error("無法獲取產品資料：", error);
    alert("無法載入產品資料，請稍後再試！");
    router.push("/");
  }
};

// 更新產品資料
const updateProduct = async () => {
  try {
    await axios.put(`http://localhost:8080/api/products/${productId}`, product.value);
    alert("產品更新成功！");
    router.push("/");
  } catch (error) {
    console.error("更新產品失敗：", error);
    alert("產品更新失敗，請稍後再試！");
  }
};

// 組件加載時獲取產品資料
onMounted(fetchProduct);
</script>

<style scoped>
.product-form {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input,
textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 14px;
}

textarea {
  resize: vertical;
  min-height: 100px;
}

button.submit-btn {
  display: block;
  width: 100%;
  padding: 10px 15px;
  background: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

button.submit-btn:hover {
  background: #0056b3;
}
</style>








