import { defineStore } from 'pinia';
import apiClient from '../api/axios'; 

export const useMainStore = defineStore('mainStore', {
    state: () => ({
      admins: [], 
      customers: [], 
    }),
    actions: {
      // admin
      async fetchAdmins() {
        try {
          const response = await apiClient.get('/admins');
          this.admins = response.data;
        } catch (error) {
          console.error('Error fetching admins:', error);
        }
      },
     
      async addAdmin(admin) {
        try {
          await apiClient.post('/admins', admin); 
        } catch (error) {
          console.error('Error adding admin:', error);
          throw error;
        }
      },
      
      async deleteAdmin(id) {
        try {
          await apiClient.delete(`/admins/${id}`);
        } catch (error) {
          console.error('Error deleting admin:', error);
          throw error; 
        }
      },

      async updateAdminUsername(id, username) {
        try {
          await apiClient.put(`/admins/${id}/username`, { username }); 
          const admin = this.admins.find((admin) => admin.id === id);
          if (admin) {
            admin.username = username; 
          }
        } catch (error) {
          console.error('Error updating admin username:', error);
          throw error; 
        }
      },

      // 客戶
      async findAllCustomers() {
        try {
          const response = await apiClient.get('/customers'); 
          this.customers = response.data; 
        } catch (error) {
          console.error('Error fetching customers:', error);
          throw error; 
        }
      },

      async addCustomer(customer) {
        try {
          await apiClient.post('/customers', customer); 
          this.findAllCustomers(); 
        } catch (error) {
          console.error('Error adding customer:', error);
          throw error; 
        }
      },

      async removeCustomerById(id) {
        try {
          await apiClient.delete(`/customers/${id}`); 
          this.findAllCustomers(); 
        } catch (error) {
          console.error('Error deleting customer:', error);
          throw error; 
        }
      },

      async updateCustomer(customer) {
        try {
          await apiClient.put(`/customers/${customer.id}`, customer); 
          this.findAllCustomers(); 
        } catch (error) {
          console.error('Error updating customer:', error);
          throw error; 
        }
      },


    },
  });
  
