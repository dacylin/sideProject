<template>
  <div>
    <h2>管理者列表</h2>
    <div class="admin-cards">
      <div class="admin-card" v-for="admin in admins" :key="admin.adminid">
        <h3>{{ admin.adminusername }}</h3>
        <p>電子郵件: {{ admin.adminemail }}</p>
        <div class="card-actions">
        
          <button @click="updateAdmin(admin.adminid)">更新</button>
          
          <button @click="deleteAdmin(admin.adminid)">刪除</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

const admins = ref([]);
const router = useRouter();

const fetchAdmins = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/admins");
    admins.value = response.data;
  } catch (error) {
    console.error("無法下載管理者列表:", error);
  }
};

const updateAdmin = (id) => {
  router.push({ name: "UpdateAdmin", params: { id } });
};

const deleteAdmin = async (id) => {
  if (confirm(`確定刪除管理者 ID: ${id}？`)) {
    try {
      await axios.delete(`http://localhost:8080/api/admins/${id}`);
      admins.value = admins.value.filter((admin) => admin.adminid !== id);
      alert("刪除成功");
    } catch (error) {
      console.error("刪除管理者失敗:", error);
    }
  }
};

onMounted(() => {
  fetchAdmins();
});
</script>

<style>
.admin-cards {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  margin-top: 20px;
}

.admin-card {
  width: 250px;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  background-color: #f9f9f9;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.admin-card h3 {
  margin: 0 0 10px;
}

.admin-card p {
  margin: 5px 0;
  color: #555;
}

.card-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
}

button {
  padding: 5px 10px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
  color: white;
}

button:first-child {
  background-color: #007bff;
  color: white;
}

button:last-child {
  background-color: #ff4d4d;
  color: white;
}
</style>



