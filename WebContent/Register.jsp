<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Register</title>

<link type="text/css" rel="stylesheet" href="ressources/css/style.css" />
</head>
<body>
	<form method="post" action="register">
		<fieldset>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>

			<label for="nom">Nom <span class="requis">*</span></label> <input
				type="text" id="nom" name="nom"
				value="<c:out value="${param.nom}"/>" size="20" maxlength="20" /> <span
				class="erreur">${form.erreurs['nom']}</span> <br /> <label
				for="prenom">Prénom <span class="requis">*</span></label> <input
				type="text" id="prenom" name="prenom"
				value="<c:out value="${param.prenom}"/>" size="20" maxlength="20" />
			<span class="erreur">${form.erreurs['prenom']}</span> <br /> <label
				for="dateNaissance">Date de naissance <span class="requis">*</span></label>
			<input type="date" id="dateNaissance" name="dateNaissance"
				value="<c:out value="${param.dateNaissance}"/>" size="20"
				maxlength="20" /> <br /> <label for="adresse">Adresse <span
				class="requis">*</span></label> <input type="text" id="adresse"
				name="adresse" value="<c:out value="${param.adresse}"/>" size="25"
				maxlength="40" /> <span class="erreur">${form.erreurs['adresse']}</span>
			<br /> <label for="numeroAdresse">Numéro adresse <span
				class="requis">*</span></label> <input type="text" id="numeroAdresse"
				name="numeroAdresse" value="<c:out value="${param.numeroAdresse}"/>"
				size="20" maxlength="20" /> <br /> <label for="idLocalite">Ville</label>
			<select name="idLocalite" id="idLocalite">
				<c:forEach items="${localites}" var="l">
					<option value="${l.idLocalite}">${l.codePostale} -
						${l.nomLocalite}</option>
				</c:forEach>

			</select><br /> <label for="email">Adresse email <span class="requis">*</span></label>
			<input type="text" id="email" name="email"
				value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
			<span class="erreur">${erreurs['email']}</span> <br /> <label
				for="login">Login<span class="requis">*</span></label> <input
				type="text" id="login" name="login"
				value="<c:out value="${param.login}"/>" size="20" maxlength="20" />
			<span class="erreur">${erreurs['login']}</span> <br /> <label
				for="motdepasse">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse"
				value="<c:out value="${param.motdepasse}"/>" size="20"
				maxlength="20" /> <span class="erreur">${erreurs['motdepasse']}</span>
			<br /> <label for="confirmation">Confirmation du mot de
				passe <span class="requis">*</span>
			</label> <input type="password" id="confirmation" name="confirmation"
				value="<c:out value="${param.confirmation}"/>" size="20"
				maxlength="20" /> <span class="erreur">${erreurs['motDePasse']}</span>
			<br /> <input type="submit" value="Register" class="sansLabel" /> <br />


		</fieldset>
	</form>
</body>
</html>