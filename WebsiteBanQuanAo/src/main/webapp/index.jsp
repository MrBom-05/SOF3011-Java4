<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body ng-app="myApp">
<h1 class="ms-5">List Student</h1>
<div ng-view></div>


<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/popper.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/angular.min.js"></script>
<script src="bootstrap/js/angular-route.js"></script>
<script>
    const app = angular.module("myApp", ["ngRoute"]);
    app.config(function ($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix("");
        $routeProvider
            .when("/list", {
                templateUrl: "views/list.jsp"
            })
            .when("/add", {
                templateUrl: "views/add.jsp"
            })
            .otherwise({
                redirectTo: '/list'
            });
    });
</script>
</body>
</html>