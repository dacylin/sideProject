<template>
  <div>
    <h2>刪除產品</h2>
    <p>確定要刪除 <strong>{{ product.productsname }}</strong> 嗎？</p>
    <button @click="deleteProduct" class="btn delete-btn">確定刪除</button>
    <router-link to="/products" class="btn">取消</router-link>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const props = defineProps(["id"]);
const product = ref({});
const router = useRouter();

const fetchProductDetails = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/products/${props.id}`);
    product.value = response.data;
  } catch (error) {
    console.error("無法載入產品資料:", error);
  }
};

const deleteProduct = async () => {
  try {
    await axios.delete(`http://localhost:8080/api/products/${props.id}`);
    alert("產品刪除成功！");
    router.push("/products"); 
  } catch (error) {
    console.error("刪除失敗:", error);
  }
};

onMounted(fetchProductDetails);
</script>

<style scoped>
form {
  max-width: 400px;
  margin: 20px auto;
  display: flex;
  flex-direction: column;
  gap: 15px;
}

label {
  font-weight: bold;
}

input,
textarea {
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 10px;
  background: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background: #0056b3;
}
</style>
