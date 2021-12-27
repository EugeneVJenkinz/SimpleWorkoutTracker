<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<form:form action="newExercise" modelAttribute="uniqueExercise">
    Exercise type <form:select path="exercise_name">
        <form:options items="${exerciseNames}"/>
    </form:select>
    <br>
    Name<form:input path="weight"/>
    <br>
    Surname<form:input path="repeats"/>
    <br>
    Surname<form:input path="relax_time"/>
    <input type="submit" value="Add another one">
</form:form>
</body>
</html>
