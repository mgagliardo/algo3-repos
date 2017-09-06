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
			<div class="panel-heading">PANTALLA PRINCIPAL</div>
			
			<form>
			<TABLE WIDTH="40%" ALIGN=CENTER CELLSPACING=10px>
          
            <tr>
              <td><label class="form-label" for="nombre">Nombre</label></td>
              <td><label class="table-label" for="calorias">Calorias</label></td>
            </tr>
            <tr>
              <td><input type="text" class="form-control" name="nombre" id="nombre" value="${appModel?.busquedaUsuario?.nombre}"></td>
              <td>De  <input type="number" class="form-control" name="caloriasMinimas" id="caloriasMinimas" value="${appModel?.busquedaUsuario?.caloriasMinimas}">  A  <input type="number" class="form-control" name="caloriasMaximas" id="caloriasMaximas" value="${appModel?.busquedaUsuario?.caloriasMaximas}"></td>
            </tr>
            <tr>
              <td><label class="form-label" for="dificultad">Dificultad</label></td>
              <td><label class="form-label" for="temporada">Temporada</label></td>
            </tr>
            <tr>
              <td><g:select id="dificultad" name='dificultad' value="${appModel?.busquedaUsuario?.dificultad}"
				    noSelection="${['null':'Seleccione una...']}"
				    from='${appModel.dificultades}'></g:select></td>
              <td><g:select id="temporada" name='temporada' value="${appModel?.busquedaUsuario?.temporada}"
				    noSelection="${['null':'Seleccione una...']}"
				    from='${appModel.temporadas}'></g:select></td>
            </tr>
            <tr>
              <td><label class="form-label" for="contenerIng">Que contenga ingrediente</label></td>
            </tr>
            <tr>
              <td><input type="text" class="form-control" name="ingrediente" id="ingrediente" value="${appModel?.busquedaUsuario?.ingrediente}"></td>
              <td><input type="checkbox" name"filtrosUsuario"/><label class="form-label" for="checkbox">Aplicar filtro de usuario</label></td>
            </tr>
         	 </TABLE>
         	 <g:actionSubmit class="secondary" action="buscar" value="Buscar" />
         	 </form>
         	  
			
			<div class="panel-body">

				<g:render template="tabla"/>
				
			</div>
		</div>
	</div>
	<form>
		<g:actionSubmit class="secondary" action="irAPantallaDeLogin" value="Volver" />
	</form>
</body>
</html>