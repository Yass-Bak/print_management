<!DOCTYPE html>
<html>
<head>
    <title>Teacher Dashboard</title>
</head>
<body>
    <h1>Welcome, ${sessionScope.user.username}</h1>
    <h2>Your Subjects</h2>
    <ul>
        <c:forEach var="subject" items="${requestScope.subjects}">
            <li>${subject.name}</li>
        </c:forEach>
    </ul>
    <h2>Request a Print</h2>
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
    <a href="<%= request.getContextPath() %>/logout">Logout</a>
</body>
</html>
