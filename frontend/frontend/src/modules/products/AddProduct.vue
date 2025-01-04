<template>
  <div class="add-product">
    <h2>新增產品</h2>
    <form @submit.prevent="submitProduct">
      <div class="form-group">
        <label for="productsname">產品名稱</label>
        <input
          type="text"
          id="productsname"
          v-model="newProduct.productsname"
          required
        />
      </div>
      <div class="form-group">
        <label for="productsprice">價格</label>
        <input
          type="number"
          id="productsprice"
          v-model="newProduct.productsprice"
          required
          min="1"
        />
      </div>
      <div class="form-group">
        <label for="productsdescribe">描述</label>
        <textarea
          id="productsdescribe"
          v-model="newProduct.productsdescribe"
          required
        ></textarea>
      </div>
      <div class="form-group">
        <label for="productspic">圖片網址</label>
        <input
          type="url"
          id="productspic"
          v-model="newProduct.productspic"
          required
        />
      </div>
      <button type="submit" class="submit-btn">新增產品</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";

// 新產品資料
const newProduct = ref({
  productsname: "",
  productsprice: null,
  productsdescribe: "",
  productspic: "",
});

// 提交新產品
const submitProduct = async () => {
  try {
    const response = await axios.post("http://localhost:8080/api/products", newProduct.value);
    alert("產品新增成功！");
    resetForm();
  } catch (error) {
    console.error("新增產品失敗：", error);
    alert("產品新增失敗，請稍後再試！");
  }
};

// 重置表單
const resetForm = () => {
  newProduct.value = {
    productsname: "",
    productsprice: null,
    productsdescribe: "",
    productspic: "",
  };
};
</script>

<style scoped>
.add-product {
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
