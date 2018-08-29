<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>

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
				class="erreur">${erreurs['nom']}</span> <br /> <label
				for="prenom">Prénom <span class="requis">*</span></label> <input
				type="text" id="prenom" name="prenom"
				value="<c:out value="${param.prenom}"/>" size="20" maxlength="20" />
			<span class="erreur">${erreurs['prenom']}</span> <br /> <label
				for="dateNaissance">Date de naissance <span class="requis">*</span></label>
			<input class="datepicker" id="dateNaissance" name="dateNaissance"
				value="<c:out value="${param.dateNaissance}"/>" size="20"
				maxlength="20" /> <br /> <label for="adresse">Adresse <span
				class="requis">*</span></label> <input type="text" id="adresse"
				name="adresse" value="<c:out value="${param.adresse}"/>" size="25"
				maxlength="40" /> <span class="erreur">${erreurs['adresse']}</span>
			<br /> <label for="numeroAdresse">Numéro adresse <span
				class="requis">*</span></label> <input type="text" id="numeroAdresse"
				name="numeroAdresse" value="<c:out value="${param.numeroAdresse}"/>"
				size="20" maxlength="20" /> <span class="erreur">${erreurs['numeroAdresse']}</span>
				
			<br>
			 <label for="boitePostale">Boite postale</label> 
			 <input type="text" id="boitePostale" name="boitePostale" value="<c:out value="${param.boitePostale}"/>" size="20" maxlength="60" />
			<span class="erreur">${erreurs['boitePostale']}</span> <br /> 
			<label for="role">Code Postal - Ville</label> 
			<select name="localite" id="localite">
				<c:forEach items="${localites}" var="l">
					<option value="${l.idLocalite}">${l.codePostale} -
						${l.nomLocalite}</option>
				</c:forEach>

			</select>
		
			
			 <br /> 
			 <label for="email">Adresse email  <span class="requis">*</span></label> 
			 <input type="text" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
			<span class="erreur">${erreurs['email']}</span> <br /> 
			
			
			<label	for="login">Login<span class="requis">*</span></label> <input
				type="text" id="login" name="login"
				value="<c:out value="${param.login}"/>" size="20" maxlength="20" />
			<span class="erreur">${erreurs['login']}</span> <br />
			
			 <label	for="motdepasse">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse"
				value="<c:out value="${param.motdepasse}"/>" size="20"
				maxlength="20" /> <span class="erreur">${erreurs['motdepasse']}</span>
			<br /> 
			
			<label for="confirmation">Confirmation du mot de passe <span class="requis">*</span>

			</label> <input type="password" id="confirmation" name="confirmation"value="<c:out value="${param.confirmation}"/>" size="20" maxlength="20" /> <span class="erreur">${form.erreurs['motDePasse']}</span>
	 
			
			<br> 
			 <label for="niss">NISS
			 <span class="requis">*</span></label> 
			 <input type="text" id="niss" name="niss" value="<c:out value="${param.niss}"/>" size="11" maxlength="11" />
			<span class="erreur">${erreurs['niss']}</span> 
				<br>
			<label for="role">Role</label> 
			<select name="role" id="role"> 
				<c:forEach items="${roles}" var="role">
					<option value="${role.idRole}">${role.nomRole}</option>
				</c:forEach>

			</select><br>
			
			<input type="submit" value="Register" class="sansLabel" /> <br />


		</fieldset>
	</form>
		<script>
            $(function () {
                $(".datepicker").datepicker({ dateFormat: 'dd-mm-yy' });
            });
        </script>
	<span class="resultat">${resultat}</span> <br /> 
	
	
			<a href="registertransport">Créer un transport</a>
 <a href="registercategorie">Créer catégorie</a>	
	<a href="registerproduit">Créer produit</a>
	  	<a href="editerproduit">Update produit</a>
	<a href="editeruser">Update profil</a>
	<a href="restreint/espacePerso">Espace client</a>
	<a href="espacePublic">Espace public</a>
	<a href="register">S'enregister</a>
	<a href="login">Se connecter</a>
</body>
</html>