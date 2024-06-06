package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.model.PrintRequest;

public class PrintRequestDao {
    private Connection connection;

    public PrintRequestDao(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter une demande d'impression
    public void addPrintRequest(PrintRequest printRequest) throws SQLException {
        String sql = "INSERT INTO print_requests (teacher_id, subject_id, pdf_document, print_date, num_copies) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, printRequest.getTeacherId());
            statement.setInt(2, printRequest.getSubjectId());
            statement.setString(3, printRequest.getPdfDocument());
            statement.setTimestamp(4, Timestamp.valueOf(printRequest.getPrintDate()));
            statement.setInt(5, printRequest.getNumCopies());
            statement.executeUpdate();
        }
    }

    // Méthode pour récupérer une demande d'impression par son ID
    public PrintRequest getPrintRequestById(int id) throws SQLException {
        String sql = "SELECT * FROM print_requests WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    PrintRequest printRequest = new PrintRequest();
                    printRequest.setId(resultSet.getInt("id"));
                    printRequest.setTeacherId(resultSet.getInt("teacher_id"));
                    printRequest.setSubjectId(resultSet.getInt("subject_id"));
                    printRequest.setPdfDocument(resultSet.getString("pdf_document"));
                    printRequest.setPrintDate(resultSet.getTimestamp("print_date").toLocalDateTime());
                    printRequest.setNumCopies(resultSet.getInt("num_copies"));
                    return printRequest;
                }
            }
        }
        return null;
    }

    // Méthode pour récupérer toutes les demandes d'impression
    public List<PrintRequest> getAllPrintRequests() throws SQLException {
        List<PrintRequest> printRequests = new ArrayList<>();
        String sql = "SELECT * FROM print_requests";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PrintRequest printRequest = new PrintRequest();
                printRequest.setId(resultSet.getInt("id"));
                printRequest.setTeacherId(resultSet.getInt("teacher_id"));
                printRequest.setSubjectId(resultSet.getInt("subject_id"));
                printRequest.setPdfDocument(resultSet.getString("pdf_document"));
                printRequest.setPrintDate(resultSet.getTimestamp("print_date").toLocalDateTime());
                printRequest.setNumCopies(resultSet.getInt("num_copies"));
                printRequests.add(printRequest);
            }
        }
        return printRequests;
    }

    // Méthode pour récupérer les demandes d'impression par l'ID de l'enseignant
    public List<PrintRequest> getPrintRequestsByTeacherId(int teacherId) throws SQLException {
        List<PrintRequest> printRequests = new ArrayList<>();
        String sql = "SELECT * FROM print_requests WHERE teacher_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, teacherId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    PrintRequest printRequest = new PrintRequest();
                    printRequest.setId(resultSet.getInt("id"));
                    printRequest.setTeacherId(resultSet.getInt("teacher_id"));
                    printRequest.setSubjectId(resultSet.getInt("subject_id"));
                    printRequest.setPdfDocument(resultSet.getString("pdf_document"));
                    printRequest.setPrintDate(resultSet.getTimestamp("print_date").toLocalDateTime());
                    printRequest.setNumCopies(resultSet.getInt("num_copies"));
                    printRequests.add(printRequest);
                }
            }
        }
        return printRequests;
    }

    // Méthode pour mettre à jour une demande d'impression
    public void updatePrintRequest(PrintRequest printRequest) throws SQLException {
        String sql = "UPDATE print_requests SET teacher_id = ?, subject_id = ?, pdf_document = ?, print_date = ?, num_copies = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, printRequest.getTeacherId());
            statement.setInt(2, printRequest.getSubjectId());
            statement.setString(3, printRequest.getPdfDocument());
            statement.setTimestamp(4, Timestamp.valueOf(printRequest.getPrintDate()));
            statement.setInt(5, printRequest.getNumCopies());
            statement.setInt(6, printRequest.getId());
            statement.executeUpdate();
        }
    }

    // Méthode pour supprimer une demande d'impression
    public void deletePrintRequest(int id) throws SQLException {
        String sql = "DELETE FROM print_requests WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
