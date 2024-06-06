package com.example.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.example.dao.SubjectDao;
import com.example.dao.UserDao;
import com.example.model.Subject;
import com.example.model.User;

public class PrintManagementApp {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/print_management", "root", "");

            UserDao userDao = new UserDao(connection);
            User user = userDao.getUserByUsername("admin");
            if (user != null) {
                System.out.println("User: " + user.getUsername() + ", Role: " + user.getRole());
            }

            SubjectDao subjectDao = new SubjectDao(connection);
            List<Subject> subjects = subjectDao.getSubjectsByTeacherId(1);
            for (Subject subject : subjects) {
                System.out.println("Subject: " + subject.getName());
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
