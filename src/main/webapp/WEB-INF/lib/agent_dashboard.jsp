<!DOCTYPE html>
<html>
<head>
    <title>Agent Dashboard</title>
</head>
<body>
    <h1>Welcome, ${sessionScope.user.username}</h1>
    <h2>Tasks for Today</h2>
    <table>
        <thead>
            <tr>
                <th>Teacher</th>
                <th>Subject</th>
                <th>PDF Document</th>
                <th>Print Date</th>
                <th>Number of Copies</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${requestScope.tasks}">
                <tr>
                    <td>${task.teacherUsername}</td>
                    <td>${task.subjectName}</td>
                    <td><a href="${task.pdfDocument}">View Document</a></td>
                    <td>${task.printDate}</td>
                    <td>${task.numCopies}</td>
                    <td><button type="button" onclick="markAsCompleted(${task.id})">Mark as Completed</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="logout">Logout</a>
    <script>
        function markAsCompleted(taskId) {
            // Code to mark the task as completed
        }
    </script>
</body>
</html>
