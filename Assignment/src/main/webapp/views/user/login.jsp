<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng Nhập</title>
    <link rel="stylesheet" href="/Assignment_war_exploded/bootstrap/css/bootstrap.min.css">
    <style>
        body {
            background-color: #eee;
        }

        .card {
            margin-top: 100px;
            max-width: 400px;
            margin-left: auto;
            margin-right: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.2);
        }

        .card-header {
            background-color: #fff;
            border-bottom: none;
        }

        .form-control:focus {
            border-color: #3F51B5;
            box-shadow: none;
        }

        .btn-primary {
            background-color: #3F51B5;
            border-color: #3F51B5;
        }

        .btn-primary:hover {
            background-color: #303F9F;
            border-color: #303F9F;
        }

        .form-label {
            font-weight: 500;
        }

        .form-text {
            margin-top: 5px;
            margin-bottom: 0;
        }

        .form-text a {
            color: #3F51B5;
        }
    </style>
</head>
<body>

<div class="card">
    <div class="card-header">
        <h4 class="text-center">Login</h4>
    </div>
    <div class="card-body">
        <form method="POST"
              action="/Assignment_war_exploded/login/store" id="form">
            <div class="mb-3">
                <label for="username" class="form-label">Email</label>
                <input type="email" class="form-control" id="username" name="email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
            <div class="form-text text-center mt-3">
                Don't have an account yet? <a href="/Assignment_war_exploded/sign-up">Register now</a>
            </div>
            <div class="form-text text-center mt-3">
                Forgot your password? <a href="#">Reset it here</a>
            </div>
        </form>
    </div>
</div>

<script src="/Assignment_war_exploded/bootstrap/js/jquery.min.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/popper.js"></script>
<script src="/Assignment_war_exploded/bootstrap/js/bootstrap.min.js"></script>
<script>
    const form = document.getElementById('form');
    form.addEventListener('submit', function (event) {
        const email = document.querySelector('input[name="email"]');
        const password = document.querySelector('input[name="password"]');

        if (!email.value || !password.value) {
            alert("Không được để trống!");
            event.preventDefault();
        }
    });

</script>
</body>
</html>
