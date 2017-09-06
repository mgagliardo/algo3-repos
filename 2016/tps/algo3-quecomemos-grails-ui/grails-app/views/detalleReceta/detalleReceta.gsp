<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>DETALLE RECETA</title>

<asset:stylesheet href="application.css" />

</head>
<body>

	<div class="container">

		<div class="panel">
			<div class="panel-heading">Detalle de receta</div>
			<div class="panel-body">

				<TABLE WIDTH="40%" ALIGN=CENTER CELLSPACING=10px>

					<tr>
						<td><label class="form-label" for="nombre">
								${appModel.receta.nombreDeLaReceta}
						</label></td>
					</tr>
					<tr>
						<td><label class="table-label" for="calorias">
								${appModel.receta.calorias }
						</label></td>
						<td><label class="table-label" for="autor">
								${appModel.receta.autor}
						</label></td>
					</tr>
					<tr>
						<td><label class="table-label" for="dificultad">
								${appModel.receta.dificultadDePreparacion}
						</label></td>
						<td><label class="table-label" for="temporada">
								${appModel.receta.temporadaALaQueCorresponde}
						</label></td>
					</tr>
					<tr>
						<td><label class="form-label" for="ingredientes">Ingredientes</label></td>
						<td><label class="form-label" for="condimentos">Condimentos</label></td>
					</tr>
					<tr>
						<td>
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<thead>
									<td>Dosis</td>
									<td>Ingrediente</td>
								</thead>
								<tbody>
									<form method="post">
										<g:each in="${appModel.receta.ingredientes}" status="i"
											var="ingrediente">
											<tr>
												<td>
													${ingrediente.nombre}
												</td>
												<td>
													${ingrediente.cantidad}
												</td>
											</tr>
										</g:each>
									</form>
								</tbody>
							</table>
						</td>
						<td>
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<tbody>
									<form method="post">
										<g:each in="${appModel.receta.condimentos}" status="i" var="condimento">
											<tr>
												<td>
													${condimento.nombre}
												</td>
											</tr>
										</g:each>
									</form>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td><g:checkBox name="favorita" checked="${appModel.favorita}" disabled="disabled"/> Favorita</td>
						<td><label class="form-label" for="condiciones">Condiciones
								Preexistentes</label><br>
							<table
								class="table table-striped table-bordered table-hover table-condensed">
								<tbody>
									<form method="post">
										<g:each in="${appModel.receta.condicionesPreexistentes}" status="i"
											var="condicion">
											<tr>
												<td>
													${condicion}
												</td>
											</tr>
										</g:each>
									</form>
								</tbody>
							</table></td>
					</tr>
					<tr>
						<td><label class="form-label" for="proceso">Proceso
								de preparacion</label>
					</tr>
					<tr>
						<td><label class="form-label" for="condiciones">
								${appModel.receta.procesoDePreparacion}
						</label>
				</TABLE>
				<form>
				<g:actionSubmit class="secondary" controller="DetalleReceta" action="volver" value="Volver"/>
				</form>
			</div>
		</div>

	</div>
	
</body>
</html>