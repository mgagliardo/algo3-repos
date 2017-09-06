<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>TP QUE COMEMOS</title>
<asset:stylesheet href="login/main.css" />
</head>
<body>


	<div class="container center">

		<div class="panel">
			<div class="panel-heading">Login</div>
			<div class="panel-body">
				<g:form class="form center" action="login">
				    <g:if test="${errorMessage}">
				      <div class="alert alert-danger" role="alert">
    					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  					    <span class="sr-only">Error:</span><div class="message">${errorMessage}</div>
					  </div>
				    </g:if>
					<div class="form-element">
						<label class="form-label" for="nombreUsuario">Usuario</label>
						<g:field class="form-input" type="text" name="nombre" />
						<br>
					</div>

					<div class="form-element">
						<label class="form-label" for="password">Contraseña</label>
						<g:field class="form-input" type="password" name="contrasenia" />
						<br>
					</div>

					<g:actionSubmit class="primary" controller="Login" action="login"
						value="OK" />
					<g:actionSubmit class="secondary" controller="Login"
						action="cancel" value="Cancelar" />
					<br>

				</g:form>
			</div>
		</div>

	</div>

</body>
</html>
