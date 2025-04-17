<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>작성</title>
</head>
<body>

<form action="insert.do" method="POST">
    <table border="1">
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" required></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><input type="text" name="content" required></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer" value="작성자값" readonly></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="작성"></td>
        </tr>
    </table>
</form>

<hr>

<a href="main.do">메인으로</a>

</body>
</html>