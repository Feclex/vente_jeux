<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Login</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<form method="post" action="login">
		<fieldset>
			<legend>Connexion</legend>
			<p>Vous pouvez vous connecter via ce formulaire.</p>


			<label for="nom">Nom d'utilisateur</label> <input type="text"
				id="nom" name="nom" value="" size="20" maxlength="20" /> <br /> <label
				for="motdepasse">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" /> <span class="erreur">${form.erreurs['motdepasse']}</span>
			<br /> <input type="submit" value="Login" class="sansLabel" /> <br />

			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
			<%-- Vérification de la présence d'un objet utilisateur en session --%>
			<c:if test="${!empty sessionScope.user}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
				<p class="succes">Vous êtes connecté(e) avec le compte :
					${sessionScope.user.nomUser}</p>

			</c:if>
		</fieldset>
	</form>
	<a href="register">S'enregister</a>
	<a href="index.jsp">Index</a>
	<a href="disconnect">Se déconnecter</a>
</body>
</html>