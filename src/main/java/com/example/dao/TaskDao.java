package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Task;

public class TaskDao {
    private Connection connection;

    public TaskDao(Connection connection) {
        this.connection = connection;
    }

    public List<Task> getTasksByAgentId(int agentId) throws SQLException {
        String query = "SELECT * FROM Tasks WHERE agent_id = ? AND status = 'pending'";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, agentId);
        ResultSet rs = statement.executeQuery();
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            Task task = new Task();
            task.setId(rs.getInt("id"));
            task.setPrintRequestId(rs.getInt("print_request_id"));
            task.setAgentId(rs.getInt("agent_id"));
            task.setStatus(rs.getString("status"));
            tasks.add(task);
        }
        return tasks;
    }

    // Autres méthodes CRUD pour Task
}
