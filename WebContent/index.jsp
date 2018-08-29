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
			<a href="registertransport">Créer un transport</a>
 <a href="registerproduit">Créer produit</a>
	  	<a href="editerproduit">Update produit</a>
	<a href="editeruser">Update profil</a>
	<a href="restreint/espacePerso">Espace client</a>
	<a href="espacePublic">Espace public</a>
	<a href="register">S'enregister</a>
	<a href="login">Se connecter</a>

</body>
</html>