<%--
  Created by IntelliJ IDEA.
  User: lapan
  Date: 17-May-18
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New test</title>
    <link href="<c:url value="/css/form.css" />" rel="stylesheet">
</head>
<body>
<div class="form-container">
    <fieldset>
    <form name="newTestForm" method="POST" action="controller">
    <input type="hidden" name="command" value="addTest"/>
        <div class="form-title">Test:</div>
    <input class="form-field" type="text" name="testname" value="" required><br/>
        <div class="form-title">Desription:</div>
    <input class="form-field" type="text" name="testdesc" value="" required><br/>
    <br/>
        <div class="form-title">Question 1:</div>
    <input class="form-field-wide" type="text" name="question1" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer1A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer1B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer1C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer1D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer1" value=""><br/>
    <br/>
        <div class="form-title">Question 2:</div>
    <input class="form-field-wide" type="text" name="question2" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer2A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer2B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer2C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer2D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer2" value=""><br/>
    <br/>
        <div class="form-title">Question 3:</div>
    <input class="form-field-wide" type="text" name="question3" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer3A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer3B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer3C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer3D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer3" value=""><br/>
    <br/>
        <div class="form-title-wide">Question 4:</div>
    <input class="form-field-wide" type="text" name="question4" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer4A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer4B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer4C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer4D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer4" value=""><br/>
    <br/>
        <div class="form-title">Question 5:</div>
    <input class="form-field-wide" type="text" name="question5" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer5A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer5B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer5C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer5D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer5" value=""><br/>
    <br/>
        <div class="form-title">Question 6:</div>
    <input class="form-field-wide" type="text" name="question6" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer6A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer6B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer6C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer6D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer6" value=""><br/>
    <br/>
        <div class="form-title">Question 7:</div>
    <input class="form-field-wide" type="text" name="question7" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer7A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer7B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer7C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer7D" value=""/><br/>
        <div class="form-title">True answer: </div><input class="form-field" type="number" name="trueAnswer7" value=""><br/>
    <br/>
        <div class="form-title">Question 8:</div>
    <input class="form-field-wide" type="text" name="question8" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer8A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer8B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer8C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer8D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer8" value=""><br/>
    <br/>
        <div class="form-title">Question 9:</div>
    <input class="form-field-wide" type="text" name="question9" value=""><br/>
    A.<input class="form-field-wide" type="text" name="answer9A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer9B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer9C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer9D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer9" value=""><br/>
        <br/>
        <div class="form-title">Question 10:</div>
    A.<input class="form-field-wide" type="text" name="answer10A" value=""/><br/>
    B.<input class="form-field-wide" type="text" name="answer10B" value=""/><br/>
    C.<input class="form-field-wide" type="text" name="answer10C" value=""/><br/>
    D.<input class="form-field-wide" type="text" name="answer10D" value=""/><br/>
        <div class="form-title">True answer:</div> <input class="form-field" type="number" name="trueAnswer10" value=""><br/>
        <br/>
        <div class="submit-container">
            <input class="submit-button" type="submit" value="Save" />
        </div>
    </form>
    </fieldset>
    <div class="form-text">${saved}</div>
    <br/>
    <div class="submit-container-center">
        <a href="/admin/adminmenu" class="submit-button">To menu</a>
    </div>
    <br/>
    <form name="testsForm" method="POST" action="/controller">
        <div class="submit-container-center">
            <input type="hidden" name="command" value="logout"/>
            <input class="submit-button" type="submit" value="Log out"/>
        </div>
    </form>
</div>
</body>
</html>
