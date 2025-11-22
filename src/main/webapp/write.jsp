<%@ page language ="java" contentType ="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>새 글 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
    <h2 class="my-4">새 글 작성</h2>

    <form action="write_ok.jsp" method="post">
        <div class="mb-3">
            <label for="first name" class="form-label">이름</label>
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="이름을 입력하세요" required>
        </div>
        <div class="mb-3">
            <label for="last name" class="form-label">성</label>
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="성을 입력하세요" required>
        </div>
        <div class="mb-3">
            <label for="age" class="form-label">나이</label>
            <input type="number" class="form-control" id="age" name="age" placeholder="나이를 입력하세요" required></input>
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">성별</label>
            <input type="text" class="form-control" id="gender" name="gender" placeholder="성별을 입력하세요(Male/Female)" required></input>
        </div>
        <div class="mb-3">
            <label for="occupation" class="form-label">직업</label>
            <input type="text" class="form-control" id="occupation" name="occupation" placeholder="직업을 입력하세요" required></input>
        </div>
        <div class="text-end">
            <button type="submit" class="btn btn-primary">저장</button>
            <a href="index.jsp" class="btn btn-secondary">취소</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<jsp:include page="footer.jsp" />
</body>
</html>