
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
				id="nom" name="nom" value="" size="20" maxlength="20"  class="form-control"  /> <span
				class="error text-danger">${erreurs['nom']}</span> 
    
  </div>
  <div class="form-group">
    <label
				for="motdepasse" class="text-uppercase">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" class="form-control"  />
				<span
				class="error text-danger">${erreurs['motdepasse']}</span>  <br>
			<input type="submit" value="Connexion" class="btn " />
			

  </div>
  <span class="resultat">${resultat}</span> <br /> 
  
  
</form>

<%-- V�rification de la pr�sence d'un objet utilisateur en session --%>
			<c:if test="${!empty sessionScope.user}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
				<p class="succes">Vous �tes connect�(e) avec le compte :
					${sessionScope.user.nomUser}</p>

			</c:if>
			
				<c:if test="${empty sessionScope.user}">
				<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
			
			<a href="afficherproduit">Je jete un oeil aux produits sans me connecter</a>
			</c:if>

  </div>
    </div>
    </div>
</section>
			
		
</body>
</html>

<%@ include file="../template/footer.jsp"%>