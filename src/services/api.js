import axios from 'axios';
const API_BASE_URL = 'http://localhost:8081/api';
const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
});
export const categoryAPI = {
    getAll: () => api.get('/categories'),
    create: (data) => api.post('/categories', data),
    update: (id, data) => api.put(`/categories/${id}`, data),
    delete: (id) => api.delete(`/categories/${id}`)
};
export const productAPI = {
    getAll: () => api.get('/products'),
    getById: (id) => api.get(`/products/${id}`),
    search: (name) => api.get(`/products/search?name=${name}`),
    create: (data) => api.post('/products', data),
    update: (id, data) => api.put(`/products/${id}`, data),
    delete: (id) => api.delete(`/products/${id}`)
};
export const customerAPI = {
    getAll: () => api.get('/customers'),
    getById: (id) => api.get(`/customers/${id}`),
    create: (data) => api.post('/customers', data),
    updateCategory: (customerId, categoryId) => api.put(`/customers/${customerId}/category/${categoryId}`)
};
export const cartAPI = {
    getCart: (customerId) => api.get(`/cart/${customerId}`),
    addItem: (customerId, productId, quantity) => api.post(`/cart/${customerId}/add?productId=${productId}&quantity=${quantity}`),
    removeItem: (customerId, cartItemId) => api.delete(`/cart/${customerId}/remove/${cartItemId}`)
};
export const orderAPI = {
    placeOrder: (customerId) => api.post(`/orders/${customerId}/place`),
    getOrders: (customerId) => api.get(`/orders/${customerId}`),
    updateStatus: (orderId, status) => api.put(`/orders/${orderId}/status?status=${status}`)
};
export const paymentAPI = {
    makePayment: (orderId, paymentMethod) => api.post(`/payments/${orderId}?paymentMethod=${paymentMethod}`)
};
export default api;