import React, { useEffect, useState } from "react";
import { addUser, getAllUsers, getUserById, updateUser, deleteUser } from "../API/APIService";
import "./UserComponent.css"
function UserComponent() {
    const [users, setUsers] = useState([]);
    const [userForm, setUserForm] = useState({ name: "", mobile: "", email: "" });
    const [editingId, setEditingId] = useState(null);

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        try {
            const response = await getAllUsers();
            setUsers(response.data);
        } catch (e) {
            console.error("Error fetching users:", e);
        }
    };

    const handleAddUser = async (e) => {
        e.preventDefault();
        try {
            await addUser(userForm);
            setUserForm({ name: "", mobile: "", email: "" });
            fetchUsers();
        } catch (e) {
            console.error("Error adding user:", e);
        }
    };

    const handleUpdateUser = async (e) => {
        e.preventDefault();
        try {
            await updateUser(editingId, userForm);
            setUserForm({ name: "", mobile: "", email: "" });
            setEditingId(null);
            fetchUsers();
        } catch (e) {
            console.error("Error updating user:", e);
        }
    };

    const handleEditClick = async (id) => {
        try {
            const response = await getUserById(id);
            setUserForm(response.data);
            setEditingId(id);
        } catch (e) {
            console.error("Error fetching user by ID:", e);
        }
    };

    const handleDeleteUser = async (id) => {
        try {
            await deleteUser(id);
            fetchUsers();
        } catch (e) {
            console.error("Error deleting user:", e);
        }
    };

    return (
        <div className="user-component">
           <center> <h2>User Management</h2>
            <form className="user-form"onSubmit={editingId ? handleUpdateUser : handleAddUser}>
                <input
                    type="text"
                    placeholder="Name"
                    value={userForm.name}
                    onChange={(e) => setUserForm({ ...userForm, name: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Mobile"
                    value={userForm.mobile}
                    onChange={(e) => setUserForm({ ...userForm, mobile: e.target.value })}
                />
                <input
                    type="email"
                    placeholder="Email"
                    value={userForm.email}
                    onChange={(e) => setUserForm({ ...userForm, email: e.target.value })}
                />
                <button type="submit">{editingId ? "Update" : "Add"}</button>
            </form></center>
            <ul className="user-list">
                {users.map((user) => (
                    <li key={user.id}>
                        {user.name} - {user.mobile} - {user.email}
                        <button onClick={() => handleEditClick(user.id)}>Edit</button>
                        <button onClick={() => handleDeleteUser(user.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default UserComponent;
