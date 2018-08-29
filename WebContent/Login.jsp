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
				id="nom" name="nom" value="" size="20" maxlength="20" /> <br /> 
				<span class="erreur">${erreurs['nom']}</span> <br /><label
				for="motdepasse">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" />
			<br /> <input type="submit" value="Login" class="sansLabel" />
				 <br />

			
			<%-- Vérification de la présence d'un objet utilisateur en session --%>
			<c:if test="${!empty sessionScope.user}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
				<p class="succes">Vous êtes connecté(e) avec le compte :
					${sessionScope.user.nomUser}</p>

			</c:if>
			
				<c:if test="${empty sessionScope.user}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
				<p class="erreurs">Login ou mot de passe incorrect</p>

			</c:if>
		</fieldset>
	</form>
	
				<a href="registercommande">Créer une commande</a>
	<a href="registertransport">Créer un transport</a>
 	<a href="registercategorie">Créer catégorie</a>
	<a href="registerproduit">Créer produit</a>
	  	<a href="editerproduit">Update produit</a>
	<a href="editeruser">Update profil</a>
	<a href="restreint/espacePerso">Espace client</a>
	<a href="espacePublic">Espace public</a>
	<a href="register">S'enregister</a>
	<a href="login">Se connecter</a>
	<a href="disconnect">Se déconnecter</a>
</body>
</html>