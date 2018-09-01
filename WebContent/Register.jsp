<%@ include file="../template/header.jsp"%>

<title>Register</title>

</head>
<body>
	<form method="post" action="register">
		<fieldset>
		
<div class="container-fluid">
    <section class="container">
		<div class="container-page">				
			<div class="col-md-6">
				<h3 class="dark-grey">Enregistrement</h3>
					<div class="form-group col-lg-12">
			<label for="nom" >Nom <span class="requis">*</span></label> <input
				type="text" class="form-control" id="nom" name="nom"
				value="<c:out value="${param.nom}"/>" size="20" maxlength="20" /> <span
				class="erreur">${erreurs['nom']}</span> </div>
				
				<div class="form-group col-lg-6">
				 <label
				for="prenom"  >Prénom <span class="requis">*</span></label> <input
				type="text" id="prenom" name="prenom"class="form-control"
				value="<c:out value="${param.prenom}"/>" size="20" maxlength="20" />
			<span class="erreur">${erreurs['prenom']}</span> </div>
			
				<div class="form-group col-lg-6">
				<label
				for="dateNaissance" >Date de naissance <span class="requis">*</span></label>
			<input class="datepicker" class="form-control" id="dateNaissance" name="dateNaissance"
				value="<c:out value="${param.dateNaissance}"/>" size="20"
				maxlength="20" /> </div>
				
				<div class="form-group col-lg-6">
				 <label for="adresse" >Adresse <span
				class="requis">*</span></label> <input type="text" id="adresse" class="form-control"
				name="adresse" value="<c:out value="${param.adresse}"/>" size="25"
				maxlength="40" /> <span class="erreur">${erreurs['adresse']}</span>
			</div>
			
			<div class="form-group col-lg-6">
			 <label for="numeroAdresse">Numéro adresse <span
				class="requis">*</span></label> <input type="text" id="numeroAdresse" class="form-control"
				name="numeroAdresse" value="<c:out value="${param.numeroAdresse}"/>"
				size="20" maxlength="20" /> <span class="erreur">${erreurs['numeroAdresse']}</span>
				
			</div>
			
			<div class="form-group col-lg-6">
			 <label for="boitePostale" >Boite postale</label> 
			 <input type="text" id="boitePostale" class="form-control" name="boitePostale" value="<c:out value="${param.boitePostale}"/>" size="20" maxlength="60" />
			<span class="erreur">${erreurs['boitePostale']}</span></div> 
			
			
			<div class="form-group col-lg-6">
			<label for="role">Code Postal - Ville</label> 
			<select name="localite" id="localite" class="form-control">
				<c:forEach items="${localites}" var="l">
					<option value="${l.idLocalite}">${l.codePostale} -
						${l.nomLocalite}</option>
				</c:forEach>

			</select>
		
			</div> 
		
		
		<div class="form-group col-lg-6">
			 <label for="email"  >Adresse email  <span class="requis">*</span></label> 
			 <input type="text" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60"class="form-control" />
			<span class="erreur">${erreurs['email']}</span></div> 
			
				<div class="form-group col-lg-6">
			<label	for="login" >Login<span class="requis">*</span></label> <input
				type="text" id="login" name="login"class="form-control"
				value="<c:out value="${param.login}"/>" size="20" maxlength="20" />
			<span class="erreur">${erreurs['login']}</span> </div> 
			
			
			<div class="form-group col-lg-6">
			 <label	for="motdepasse" >Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse"class="form-control"
				value="<c:out value="${param.motdepasse}"/>" size="20"
				maxlength="20" /> <span class="erreur">${erreurs['motdepasse']}</span>
		</div> 
			<div class="form-group col-lg-6">
			<label for="confirmation"  >Confirmation du mot de passe <span class="requis">*</span>

			</label> <input type="password" id="confirmation" class="form-control" name="confirmation"value="<c:out value="${param.confirmation}"/>" size="20" maxlength="20" /> <span class="erreur">${form.erreurs['motDePasse']}</span>
	 
			
		</div> 
		
		<div class="form-group col-lg-6">
			 <label for="niss" >NISS
			 <span class="requis">*</span></label> 
			 <input type="text" id="niss" class="form-control" name="niss" value="<c:out value="${param.niss}"/>" size="11" maxlength="11" />
			<span class="erreur">${erreurs['niss']}</span> 
				</div> 
				
				<div class="form-group col-lg-6">	
			<label for="role" >Role</label> 
			<select name="role" id="role" class="form-control"> 
				<c:forEach items="${roles}" var="role">
					<option value="${role.idRole}">${role.nomRole}</option>
				</c:forEach>

			</select></div> 
				
			
			<input type="submit" value="Register" class="btn" /> <br />
<span class="resultat">${resultat}</span> <br /> 
	

		
			</div>
		
	
		</div>
	</section>
</div>
		</fieldset>
	</form>
		<script>
            $(function () {
                $(".datepicker").datepicker({ dateFormat: 'dd-mm-yy' });
            });
        </script>
	
</body>
</html>

<%@ include file="../template/footer.jsp"%>