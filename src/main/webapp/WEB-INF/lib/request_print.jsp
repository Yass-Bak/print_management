<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Request Print</title>
</head>
<body>
    <h1>Request Print</h1>
    <form action="request_print" method="post">
        <label for="subject_id">Subject:</label>
        <select id="subject_id" name="subject_id">
            <c:forEach var="subject" items="${requestScope.subjects}">
                <option value="${subject.id}">${subject.name}</option>
            </c:forEach>
        </select>
        <br>
        <label for="pdf_document">PDF Document:</label>
        <input type="text" id="pdf_document" name="pdf_document" required>
        <br>
        <label for="print_date">Print Date:</label>
        <input type="datetime-local" id="print_date" name="print_date" required>
        <br>
        <label for="num_copies">Number of Copies:</label>
        <input type="number" id="num_copies" name="num_copies" required>
        <br>
        <button type="submit">Request Print</button>
    </form>
</body>
</html>
