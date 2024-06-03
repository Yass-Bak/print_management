<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Welcome, ${sessionScope.user.username}</h1>
    <h2>Manage Users</h2>
    <form action="manage_users" method="post">
        <input type="hidden" name="action" value="create">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="teacher">Teacher</option>
            <option value="agent">Agent</option>
            <option value="admin">Admin</option>
        </select>
        <br>
        <button type="submit">Create User</button>
    </form>
    <h2>Activate/Deactivate Users</h2>
    <form action="manage_users" method="post">
        <input type="hidden" name="action" value="activate">
        <label for="user_id">User ID:</label>
        <input type="number" id="user_id" name="user_id" required>
        <button type="submit">Activate User</button>
    </form>
    <form action="manage_users" method="post">
        <input type="hidden" name="action" value="deactivate">
        <label for="user_id">User ID:</label>
        <input type="number" id="user_id" name="user_id" required>
        <button type="submit">Deactivate User</button>
    </form>
    <a href="logout">Logout</a>
</body>
</html>
