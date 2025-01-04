<template>
  <div class="product-form">
    <h2>刪除產品</h2>
    <p>您確定要刪除產品 <strong>{{ product.productsname }}</strong> 嗎？</p>
    <div class="actions">
      <button @click="deleteProduct" class="delete-btn">刪除</button>
      <button @click="cancel" class="cancel-btn">取消</button>
    </div>
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

// 刪除產品資料
const deleteProduct = async () => {
  try {
    await axios.delete(`http://localhost:8080/api/products/${productId}`);
    alert("產品刪除成功！");
    router.push("/");
  } catch (error) {
    console.error("刪除產品失敗：", error);
    alert("產品刪除失敗，請稍後再試！");
  }
};

// 取消刪除操作
const cancel = () => {
  router.push("/");
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
  text-align: center;
}

h2 {
  margin-bottom: 20px;
}

.actions {
  margin-top: 20px;
}

button.delete-btn {
  padding: 10px 20px;
  background: #e74c3c;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  margin-right: 10px;
}

button.delete-btn:hover {
  background: #c0392b;
}

button.cancel-btn {
  padding: 10px 20px;
  background: #7f8c8d;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

button.cancel-btn:hover {
  background: #5d6d7e;
}
</style>



  