
<%@ include file="../template/header.jsp"%>

<title>Login</title>

</head>
<body>


<section class="login-block">
    <div class="container">
	<div class="row ">	
		<div class="col login-sec">
		    <h2 class="text-left">Connectez-vous</h2>
		 	<form method="post" action="login" class="login-form">   
		 	  <div class="form-group">
 	<label for="nom" class="text-uppercase">Nom d'utilisateur<span class="requis">*</span></label> <input type="text"
				id="nom" name="nom" value="" size="20" maxlength="20"  class="form-control"  /> 
				<span class="erreur">${erreurs['nom']}</span> 
    
  </div>
  <div class="form-group">
    <label
				for="motdepasse" class="text-uppercase">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" class="form-control"  /> <br>
			<input type="submit" value="Login" class="btn " />

  </div>
  
  
</form>

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
  </div>
    </div>
    </div>
</section>
			
		
</body>
</html>

<%@ include file="../template/footer.jsp"%>