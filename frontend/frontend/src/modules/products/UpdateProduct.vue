<template>
  <div>
    <h2>更新產品</h2>
    <form @submit.prevent="submitUpdate">
      <div>
        <label for="name">產品名稱：</label>
        <input id="name" v-model="product.productsname" type="text" />
      </div>
      <div>
        <label for="price">價格：</label>
        <input id="price" v-model="product.productsprice" type="number" />
      </div>
      <div>
        <label for="description">描述：</label>
        <textarea id="description" v-model="product.productsdescribe"></textarea>
      </div>
      <button type="submit">提交更新</button>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";

const props = defineProps(["id"]);

const product = ref({
  productsname: "",
  productsprice: "",
  productsdescribe: "",
});

const fetchProductDetails = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/products/${props.id}`);
    product.value = response.data;
  } catch (error) {
    console.error("無法載入產品資料:", error);
  }
};

const submitUpdate = async () => {
  try {
    await axios.put(`http://localhost:8080/api/products/${props.id}`, product.value);
    alert("產品更新成功！");
  } catch (error) {
    console.error("更新失敗:", error);
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
