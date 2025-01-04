import axios from 'axios';

const API_URL = 'http://localhost:8080/api/products';

export default {
  getAllProducts() {
    return axios.get(API_URL);
  },
  getProductById(productsid) {
    return axios.get(`${API_URL}/${productsid}`);
  },
  addProduct(product) {
    return axios.post(API_URL, product);
  },
  updateProduct(productsid, product) {
    return axios.put(`${API_URL}/${productsid}`, product);
  },
  deleteProduct(productsid) {
    return axios.delete(`${API_URL}/${productsid}`);
  },
};

