<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" />
<title></title>
</head>


<body>
	Bienvenu(e) ${sessionScope.user.prenomUser}
	${sessionScope.user.nomUser}

	<br>
	<a href="register">S'enregister</a>
	<a href="login">Se connecter</a>

</body>
</html>