<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 17-May-18
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New test</title>
</head>
<body>
<form name="newTestForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addTest"/>
    Test:
    <input type="text" name="testname" value="" required><br/>
    Desription:
    <input type="text" name="testdesc" value="" required><br/>
    <br/>Question 1:
    <input type="text" name="question1" value=""><br/>
    A.<input type="text" name="answer1A" value=""/><br/>
    B.<input type="text" name="answer1B" value=""/><br/>
    C.<input type="text" name="answer1C" value=""/><br/>
    D.<input type="text" name="answer1D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer1" value=""><br/>
    <br/>Question 2:
    <input type="text" name="question2" value=""><br/>
    A.<input type="text" name="answer2A" value=""/><br/>
    B.<input type="text" name="answer2B" value=""/><br/>
    C.<input type="text" name="answer2C" value=""/><br/>
    D.<input type="text" name="answer2D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer2" value=""><br/>
    <br/>Question 3:
    <input type="text" name="question3" value=""><br/>
    A.<input type="text" name="answer3A" value=""/><br/>
    B.<input type="text" name="answer3B" value=""/><br/>
    C.<input type="text" name="answer3C" value=""/><br/>
    D.<input type="text" name="answer3D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer3" value=""><br/>
    <br/>Question 4:
    <input type="text" name="question4" value=""><br/>
    A.<input type="text" name="answer4A" value=""/><br/>
    B.<input type="text" name="answer4B" value=""/><br/>
    C.<input type="text" name="answer4C" value=""/><br/>
    D.<input type="text" name="answer4D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer4" value=""><br/>
    <br/>Question 5:
    <input type="text" name="question5" value=""><br/>
    A.<input type="text" name="answer5A" value=""/><br/>
    B.<input type="text" name="answer5B" value=""/><br/>
    C.<input type="text" name="answer5C" value=""/><br/>
    D.<input type="text" name="answer5D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer5" value=""><br/>
    <br/>Question 6:
    <input type="text" name="question6" value=""><br/>
    A.<input type="text" name="answer6A" value=""/><br/>
    B.<input type="text" name="answer6B" value=""/><br/>
    C.<input type="text" name="answer6C" value=""/><br/>
    D.<input type="text" name="answer6D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer6" value=""><br/>
    <br/>Question 7:
    <input type="text" name="question7" value=""><br/>
    A.<input type="text" name="answer7A" value=""/><br/>
    B.<input type="text" name="answer7B" value=""/><br/>
    C.<input type="text" name="answer7C" value=""/><br/>
    D.<input type="text" name="answer7D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer7" value=""><br/>
    <br/>Question 8:
    <input type="text" name="question8" value=""><br/>
    A.<input type="text" name="answer8A" value=""/><br/>
    B.<input type="text" name="answer8B" value=""/><br/>
    C.<input type="text" name="answer8C" value=""/><br/>
    D.<input type="text" name="answer8D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer8" value=""><br/>
    <br/>Question 9:
    <input type="text" name="question9" value=""><br/>
    A.<input type="text" name="answer9A" value=""/><br/>
    B.<input type="text" name="answer9B" value=""/><br/>
    C.<input type="text" name="answer9C" value=""/><br/>
    D.<input type="text" name="answer9D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer9" value=""><br/>
    <br/>Question 10:
    <input type="text" name="question10" value=""><br/>
    A.<input type="text" name="answer10A" value=""/><br/>
    B.<input type="text" name="answer10B" value=""/><br/>
    C.<input type="text" name="answer10C" value=""/><br/>
    D.<input type="text" name="answer10D" value=""/><br/>
    True answer: <input type="number" name="trueAnswer10" value=""><br/>
    <br/><input type="submit" value="Save"/>
</form><hr/>
${saved}
<form name="toAdminMenu" method="POST" action="admin/adminmenu">
    <input type="submit" value="Back to menu"/>
</form>
<form name="logout" method="POST" action="controller">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Log out"/>
</form>
</body>
</html>
