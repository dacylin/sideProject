<template>
  <div class="delete-admin">
    <h1>刪除管理員</h1>
    <p>您確定要刪除以下管理員嗎？此操作無法撤銷</p>
    <div class="admin-details">
      <p><strong>ID：</strong>{{ admin.adminid }}</p>
      <p><strong>用戶名：</strong>{{ admin.adminusername }}</p>
      <p><strong>Email：</strong>{{ admin.adminemail }}</p>
    </div>
    <div class="actions">
      <button class="btn delete-btn" @click="deleteAdmin">確定刪除</button>
      <button class="btn cancel-btn" @click="cancelDelete">取消</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const admin = ref({});
const route = useRoute();
const router = useRouter();
const adminId = route.params.id;

const fetchAdmin = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/admins/${adminId}`);
    admin.value = response.data; 
  } catch (error) {
    console.error("無法載入管理員數據：", error);
    alert("管理員數據加載失敗！");
  }
};

const deleteAdmin = async () => {
  try {
    await axios.delete(`http://localhost:8080/api/admins/${adminId}`); 
    alert("刪除成功！");
    router.push("/admins");
  } catch (error) {
    console.error("刪除失敗：", error);
    alert("管理員刪除失敗！");
  }
};

const cancelDelete = () => {
  router.push("/admins"); // 返回管理員列表頁面
};

onMounted(fetchAdmin); // 頁面加載時獲取管理員數據
</script>

<style scoped>
.delete-admin {
  max-width: 600px;
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background: #fff;
  text-align: center;
}

.admin-details {
  margin-bottom: 20px;
  text-align: left;
}

.actions {
  display: flex;
  justify-content: space-around;
}

button {
  padding: 10px 20px;
  font-size: 14px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.delete-btn {
  background-color: #e74c3c;
  color: #fff;
}

.delete-btn:hover {
  background-color: #c0392b;
}

.cancel-btn {
  background-color: #007bff;
  color: #fff;
}

.cancel-btn:hover {
  background-color: #0056b3;
}
</style>
