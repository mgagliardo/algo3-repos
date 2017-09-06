<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>COPIAR RECETA</title>

  <asset:stylesheet href="application.css"/>

</head>
<body>

<div class="container">

  <div class="panel">
    <div class="panel-heading">Copiar Receta</div>
    <div class="panel-body">
		<form method="post">
		<div id:"nombreDeCopia">Nombre de copia: </div>
		<g:if test="${errorMessage}">
	      <div class="alert alert-danger" role="alert">
		    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  		    <div class="message">${errorMessage}</div>
		  </div>
        </g:if>
		<g:field class="form-input" type="text" name="nombreDeCopia" value="${appModel?.receta?.nombreDeLaReceta}"/>
		<g:actionSubmit class="primary" controller="CopiarReceta" action="copiarRecetaNombre" value="Copiar"/>
		<g:actionSubmit class="secondary" action="volver" value="Volver"/>
		</form>							
  	</div>
	</div>
   </div> 	

</body>
</html>