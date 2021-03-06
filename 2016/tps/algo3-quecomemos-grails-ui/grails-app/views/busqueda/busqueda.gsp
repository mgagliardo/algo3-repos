<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>TP QUE COMEMOS</title>

<asset:stylesheet href="application.css" />

</head>
<body>

	<div class="container">

		<div class="panel">
			<div class="panel-heading">Busqueda</div>
			<div class="panel-body">

				<div id="list-receta" class="content scaffold-list">
					<table
						class="table table-striped table-bordered table-hover table-condensed">
						<thead>
							<td>Nombre</td>
							<td>Calorias</td>
							<td>Dificultad</td>
							<td>Temporada</td>
						</thead>
						<tbody>
							<form method="post">
								<g:each in="${recetaList}" status="i" var="receta">
									<tr bgcolor="${appModel.colorear(receta)}">
										<td>
											${receta.nombreDeLaReceta}
										
										<td>
											${receta.calorias}
										</td>
										<td>
											${receta.dificultadDePreparacion}
										</td>
										<td>
											${receta.temporadaALaQueCorresponde}
										</td>
										<td>
										<g:form action="ver">
									      <g:hiddenField name="nombreReceta" value="${receta.nombreDeLaReceta}" />
										  <g:actionSubmit class="primary" action="ver" value="Ver" />
										  <g:actionSubmit class="primary" action="marcarFavorita" value="Favorita" />
										  <g:actionSubmit class="primary" action="irAPantallaDeCopia" value="Copiar" />
										</g:form>
										</td>
									</tr>
								</g:each>
							</form>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<form>
		<g:actionSubmit class="secondary" action="irAPantallaDeLogin" value="Volver" />
	</form>
</body>
</html>