<template>
  <div>
    <!-- Add a back button -->
    <button @click="goBack">Back to Dashboard</button>

    <h1>Admins Management</h1>
    <table border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Username</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <!-- 顯示所有管理員 -->
        <tr v-for="admin in store.admins" :key="admin.id">
          <td>{{ admin.id }}</td>
          <td>
            <!-- 根據 editId 判斷顯示文字還是輸入框 -->
            <span v-if="editId !== admin.id">{{ admin.username }}</span>
            <input 
              v-else 
              v-model="editUsername" 
              placeholder="New Username" 
            />
          </td>
          <td>
             <!-- 按鈕：Edit、Save 和 Delete -->
            <button v-if="editId !== admin.id" @click="enterEditMode(admin)">Edit</button>
            <button v-else @click="updateAdmin(admin.id)">Save</button>
            <button @click="deleteAdmin(admin.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>

    <!-- 新增管理員 -->
    <h2>Add Admin</h2>
    <form @submit.prevent="addAdmin">
      <input v-model="newAdmin.username" placeholder="Username" required />
      <input v-model="newAdmin.password" type="password" placeholder="Password" required />
      <button type="submit">Add Admin</button>
    </form>
  </div>
</template>


<script setup>
import { useRouter } from 'vue-router';
import { useMainStore } from '../stores/mainStore';
import { onMounted, ref } from 'vue';

const router = useRouter();
const store = useMainStore();
const newAdmin = ref({ username: '', password: '' });
const editId = ref(null); // 編輯模式的 ID
const editUsername = ref(''); // 編輯模式下的 username

onMounted(() => {
  store.fetchAdmins(); // 初次載入時從後端獲取所有管理員
});

const goBack = () => {
  router.push('/'); // 導航到主頁或其他頁面
};

// 進入編輯模式
const enterEditMode = (admin) => {
  editId.value = admin.id;
  editUsername.value = admin.username;
};



// 更新管理員的 username
const updateAdmin = async (id) => {
  if (!editUsername.value.trim()) {
    alert('Username cannot be empty!');
    return;
  }
  try {
    await store.updateAdminUsername(id, editUsername.value); // 調用 Pinia 更新方法
    const admin = store.admins.find((a) => a.id === id);
    if (admin) {
      admin.username = editUsername.value; // 本地數據同步
    }
    editId.value = null; // 退出編輯模式
    editUsername.value = ''; // 清空輸入框
  } catch (error) {
    console.error('Error updating admin:', error);
  }
};

// 新增管理員
const addAdmin = async () => {
  if (newAdmin.value.username && newAdmin.value.password) {
    try {
      await store.addAdmin(newAdmin.value); // 調用 Pinia 中的新增方法
      newAdmin.value = { username: '', password: '' }; // 重置表單
    } catch (error) {
      console.error('Error adding admin:', error);
    }
  }
};

// 刪除管理員
const deleteAdmin = async (id) => {
  if (confirm('Are you sure you want to delete this admin?')) {
    try {
      await store.deleteAdmin(id); // 調用 Pinia 中的刪除方法
      store.admins = store.admins.filter((admin) => admin.id !== id); // 從本地數據中移除
    } catch (error) {
      console.error('Error deleting admin:', error);
    }
  }
};
</script>x

<style>
form {
  margin-top: 20px;
}
table {
  margin-top: 20px;
  width: 100%;
  border-collapse: collapse;
}
th, td {
  padding: 10px;
  text-align: left;
}
</style>