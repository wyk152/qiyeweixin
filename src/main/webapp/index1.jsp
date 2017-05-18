<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/Vue.min.js"></script>
<script type="text/javascript" src="js/angular.min.js"></script>
</head>
<body>
<div id="app">
  <p>{{ message }}</p>
</div>
<div ng-app="">
	<p>名字 : <input type="text" ng-model="name"></p>
	 Hello {{name}}
</div>
</body>

<script>
	new Vue({
		  el: '#app',
		  data: {
		    message: 'Hello Vue.js!'
		  }
		})
</script>
</html>