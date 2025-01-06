<template>
  <div class="login">
    <form @submit.prevent="login">
      <h2>管理系统登入</h2>
      <div class="form-group">
        <label for="username">用户名稱</label>
        <input
          type="text"
          id="username"
          v-model="adminusername"
          placeholder="請輸入用戶名稱"
          required
        />
      </div>
      <div class="form-group">
        <label for="password">密碼</label>
        <input
          type="password"
          id="password"
          v-model="adminpassword"
          placeholder="請輸入密碼"
          required
        />
      </div>
      <button type="submit" class="btn">登入</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const adminusername = ref("");
const adminpassword = ref("");

const router = useRouter();

const login = async () => {
  try {
    const response = await axios.post("http://localhost:8080/api/admins/login", {
      adminusername: adminusername.value,
      adminpassword: adminpassword.value,
    });

  
    localStorage.setItem("admin", JSON.stringify(response.data));

    router.push("/products");
  } catch (error) {
    console.error("登入失敗：", error);
    alert("登入失敗，請重新輸入！");
  }
};
</script>

<style scoped>
.login {
  max-width: 400px;
  margin: 100px auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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

input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 14px;
}

button {
  width: 100%;
  padding: 10px;
  background: #007bff;
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
