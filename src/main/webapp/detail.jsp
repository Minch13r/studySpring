<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세</title>
</head>
<body>

<form action="update.do" method="POST">
    <input type="hidden" name="bid" value="bid값">
    <table border="1">
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value="title값"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><input type="text" name="content" value="content값"></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>작성자값</td>
        </tr>
        <tr>
            <td>조회수</td>
            <td>조회수값</td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit" value="변경">&nbsp;&nbsp;&nbsp;<a href="delete.do">삭제</a></td>
        </tr>
    </table>
</form>

<hr>

<a href="main.do">메인으로</a>

</body>
</html>