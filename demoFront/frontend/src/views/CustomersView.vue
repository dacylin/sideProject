<template>
  <div>
    <h1>Customers Management</h1>
    <!-- 返回按鈕 -->
    <button @click="goBack" style="margin-bottom: 20px;">返回</button>
    <table border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Password</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="customer in store.customers" :key="customer.id">
          <td>{{ customer.id }}</td>
          <td>
            <span v-if="editId !== customer.id">{{ customer.name }}</span>
            <input v-else v-model="editName" placeholder="New Name" />
          </td>
          <td>
            <span v-if="editId !== customer.id">{{ customer.email }}</span>
            <input v-else v-model="editEmail" placeholder="New Email" />
          </td>
          <td>
            <span v-if="editId !== customer.id">******</span>
            <input v-else v-model="editPassword" placeholder="New Password" />
          </td>
          <td>
            <button v-if="editId !== customer.id" @click="enterEditMode(customer)">Edit</button>
            <button v-else @click="updateCustomer(customer.id)">Save</button>
            <button @click="deleteCustomer(customer.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>

    <h2>Add Customer</h2>
    <form @submit.prevent="addCustomer">
      <input v-model="newCustomer.name" placeholder="Name" required />
      <input v-model="newCustomer.email" type="email" placeholder="Email" required />
      <input v-model="newCustomer.password" type="password" placeholder="Password" required />
      <button type="submit">Add Customer</button>
    </form>
  </div>
</template>

<script setup>
import { useMainStore } from '../stores/mainStore';
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

const store = useMainStore();
const router = useRouter();

const newCustomer = ref({
  name: '',
  email: '',
  password: '',
});
const editId = ref(null);
const editName = ref('');
const editEmail = ref('');
const editPassword = ref('');

onMounted(() => {
  console.log('Fetching customers...');
  store.findAllCustomers(); // 確保拉取所有會員數據
});

const goBack = () => {
  router.back();
};

const enterEditMode = (customer) => {
  editId.value = customer.id;
  editName.value = customer.name;
  editEmail.value = customer.email;
  editPassword.value = customer.password;
};

const updateCustomer = async (id) => {
  if (!editName.value.trim() || !editEmail.value.trim() || !editPassword.value.trim()) {
    alert('Fields cannot be empty!');
    return;
  }
  try {
    await store.updateCustomer({
      id,
      name: editName.value,
      email: editEmail.value,
      password: editPassword.value,
    });
    editId.value = null;
    editName.value = '';
    editEmail.value = '';
    editPassword.value = '';
  } catch (error) {
    console.error('Error updating customer:', error);
  }
};

const addCustomer = async () => {
  if (newCustomer.value.name && newCustomer.value.email && newCustomer.value.password) {
    try {
      await store.addCustomer({
        name: newCustomer.value.name,
        email: newCustomer.value.email,
        password: newCustomer.value.password,
      });
      newCustomer.value = { name: '', email: '', password: '' };
    } catch (error) {
      console.error('Error adding customer:', error);
    }
  } else {
    alert('All fields are required!');
  }
};

const deleteCustomer = async (id) => {
  if (confirm('Are you sure you want to delete this customer?')) {
    try {
      await store.removeCustomerById(id);
    } catch (error) {
      console.error('Error deleting customer:', error);
    }
  }
};
</script>

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


