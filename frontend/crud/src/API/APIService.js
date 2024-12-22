import axios from "axios";


const BASE_URL = "http://localhost:8080/api/v1/crud";

export const addUser = async (userData) => {
    return await axios.post(`${BASE_URL}/save`, userData);
};

export const getAllUsers = async () => {
    return await axios.get(`${BASE_URL}/getAll`);
};

export const getUserById = async (id) => {
    return await axios.get(`${BASE_URL}/get/${id}`);
};

export const updateUser = async (id, updatedData) => {
    return await axios.put(`${BASE_URL}/update/${id}`, updatedData);
};

export const deleteUser = async (id) => {
    return await axios.delete(`${BASE_URL}/delete/${id}`);
};