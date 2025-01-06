<template>
  <div class="add-admin">
    <h2>新增管理員</h2>
    <form @submit.prevent="addAdmin">
      <div class="form-group">
        <label for="username">用戶名</label>
        <input type="text" id="username" v-model="admin.adminusername" placeholder="請輸入用戶名" required />
      </div>
      <div class="form-group">
        <label for="password">密碼</label>
        <input type="password" id="password" v-model="admin.adminpassword" placeholder="請輸入密碼" required />
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" v-model="admin.adminemail" placeholder="請輸入 Email" required />
      </div>
      <button type="submit">新增管理員</button>
    </form>
  </div>
</template>

<script setup>
import { reactive } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const admin = reactive({
  adminusername: "",
  adminpassword: "",
  adminemail: "",
});

const router = useRouter();

const addAdmin = async () => {
  try {
    await axios.post("http://localhost:8080/api/admins", admin); 
    alert("新增管理員成功！");
    router.push("/admins");
  } catch (error) {
    console.error("新增失敗：", error);
    alert("新增管理員失敗！");
  }
};
</script>

<style scoped>
.add-admin {
  max-width: 600px;
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

input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 14px;
}

button {
  display: block;
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
  background-color: #0056b3;
}
</style>
