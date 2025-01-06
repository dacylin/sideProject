<template>
  <div class="add-product">
    <h2>新增產品</h2>
    <form @submit.prevent="addProduct">
      <div class="form-group">
        <label for="productsname">產品名稱</label>
        <input
          type="text"
          id="productsname"
          v-model="product.productsname"
          placeholder="請輸入產品名稱"
          required
        />
      </div>

      <div class="form-group">
        <label for="productsprice">產品價格</label>
        <input
          type="number"
          id="productsprice"
          v-model="product.productsprice"
          placeholder="請輸入產品價格"
          required
        />
      </div>

      <div class="form-group">
        <label for="productsdescribe">產品描述</label>
        <textarea
          id="productsdescribe"
          v-model="product.productsdescribe"
          placeholder="請輸入產品描述"
          required
        ></textarea>
      </div>

      <div class="form-group">
        <label for="productspic">產品圖片 URL</label>
        <input
          type="text"
          id="productspic"
          v-model="product.productspic"
          placeholder="請輸入圖片網址"
          required
        />
      </div>

      <button type="submit" class="btn">新增產品</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";

const product = ref({
  productsname: "",
  productsprice: "",
  productsdescribe: "",
  productspic: "",
});

const addProduct = async () => {
  try {
    const response = await axios.post("http://localhost:8080/api/products", product.value);
    alert("新增產品成功！");
    console.log("新增成功：", response.data);
    product.value = {
      productsname: "",
      productsprice: "",
      productsdescribe: "",
      productspic: "",
    };
  } catch (error) {
    console.error("新增產品失敗：", error);
    alert("新增產品失敗，請稍後再試！");
  }
};
</script>

<style scoped>
.add-product {
  max-width: 400px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background: #fff;
}

.form-group {
  margin-bottom: 15px;

}

h2 {
  text-align: center;
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 5px;
}

input,
textarea {
  display: block;
  width: calc(100% - 16px); 
  max-width: 100%;
  box-sizing: border-box;
  margin: 0;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 14px;
}

textarea {
  resize: vertical;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background: #0056b3;
}
</style>
