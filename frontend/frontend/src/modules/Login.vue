<template>
  <div class="login">
    <form @submit.prevent="login">
      <h2>管理系统登录</h2>
      <div class="form-group">
        <label for="username">用户名</label>
        <input
          type="text"
          id="username"
          v-model="adminusername"
          placeholder="请输入用户名"
          required
        />
      </div>
      <div class="form-group">
        <label for="password">密码</label>
        <input
          type="password"
          id="password"
          v-model="adminpassword"
          placeholder="请输入密码"
          required
        />
      </div>
      <button type="submit" class="btn">登录</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

// 定义数据
const adminusername = ref("");
const adminpassword = ref("");

// 使用 Vue Router
const router = useRouter();

// 登录方法
const login = async () => {
  try {
    const response = await axios.post("http://localhost:8080/api/admins/login", {
      adminusername: adminusername.value,
      adminpassword: adminpassword.value,
    });

    // 登录成功后，将管理员信息存储到 localStorage
    localStorage.setItem("admin", JSON.stringify(response.data));

    // 跳转到商品管理页面
    router.push("/products");
  } catch (error) {
    console.error("登录失败：", error);
    alert("登录失败，请检查用户名或密码！");
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
