<template>
  <div>
    <h2>更新管理者</h2>
    <form @submit.prevent="submitUpdate">
      <div>
        <label for="username">用戶名稱：</label>
        <input id="username" v-model="admin.username" type="text" />
      </div>
      <div>
        <label for="email">電子郵件：</label>
        <input id="email" v-model="admin.email" type="email" />
      </div>
      <div>
        <label for="password">密碼：</label>
        <input id="password" v-model="admin.password" type="password" />
      </div>
      <button type="submit">提交</button>
    </form>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const route = useRoute();
const router = useRouter();
const admin = ref({
  username: "",
  email: "",
  password: "",
});

const fetchAdmin = async () => {
  try {
    const response = await axios.get(
      `http://localhost:8080/api/admins/${route.params.id}`
    );
    admin.value = {
      username: response.data.adminusername,
      email: response.data.adminemail,
      password: "", 
    };
  } catch (error) {
    console.error("無法下載管理者資料:", error);
  }
};


const submitUpdate = async () => {
  try {
    await axios.put(
      `http://localhost:8080/api/admins/${route.params.id}`,
      {
        adminusername: admin.value.username,
        adminemail: admin.value.email,
        adminpassword: admin.value.password,
      }
    );
    alert("更新成功！");
    router.push({ name: "Admins" }); 
  } catch (error) {
    console.error("更新失敗:", error);
  }
};

onMounted(() => {
  fetchAdmin();
});
</script>

<style>
form {
  display: flex;
  flex-direction: column;
  gap: 15px;
  max-width: 400px;
}

label {
  font-weight: bold;
}

input {
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

button {
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>



  