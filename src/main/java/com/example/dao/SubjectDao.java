package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Subject;

public class SubjectDao {
    private Connection connection;

    public SubjectDao(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter un sujet
    public void addSubject(Subject subject) throws SQLException {
        String sql = "INSERT INTO subjects (name, teacher_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subject.getName());
            statement.setInt(2, subject.getTeacherId());
            statement.executeUpdate();
        }
    }

    // Méthode pour récupérer un sujet par son ID
    public Subject getSubjectById(int id) throws SQLException {
        String sql = "SELECT * FROM subjects WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setId(resultSet.getInt("id"));
                    subject.setName(resultSet.getString("name"));
                    subject.setTeacherId(resultSet.getInt("teacher_id"));
                    return subject;
                }
            }
        }
        return null;
    }

    // Méthode pour récupérer tous les sujets
    public List<Subject> getAllSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subjects";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("name"));
                subject.setTeacherId(resultSet.getInt("teacher_id"));
                subjects.add(subject);
            }
        }
        return subjects;
    }

    // Méthode pour récupérer les sujets par l'ID de l'enseignant
    public List<Subject> getSubjectsByTeacherId(int teacherId) throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subjects WHERE teacher_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setId(resultSet.getInt("id"));
                    subject.setName(resultSet.getString("name"));
                    subject.setTeacherId(resultSet.getInt("teacher_id"));
                    subjects.add(subject);
                }
            }
        }
        return subjects;
    }

    // Méthode pour mettre à jour un sujet
    public void updateSubject(Subject subject) throws SQLException {
        String sql = "UPDATE subjects SET name = ?, teacher_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, subject.getName());
            statement.setInt(2, subject.getTeacherId());
            statement.setInt(3, subject.getId());
            statement.executeUpdate();
        }
    }

    // Méthode pour supprimer un sujet
    public void deleteSubject(int id) throws SQLException {
        String sql = "DELETE FROM subjects WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
