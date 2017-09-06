package controller

import appModel.PantallaLoginAplicationModel
import appModel.PantallaPrincipalAplicationModel
import ar.tp.dieta.CriterioBusqueda
import ar.tp.dieta.Receta
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import appModel.PantallaPrincipalAplicationModel
import appModel.CopiarRecetaAplicationModel
import org.uqbar.xtrest.api.annotation.Put
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Controller
class RecetasController {

	public var loginApp = new PantallaLoginAplicationModel()
	public var PantallaPrincipalAplicationModel principalApp
	extension JSONUtils = new JSONUtils

	def static void main(String[] args) {
		XTRest.start(RecetasController, 9000)
	}

	@Post('/login/')
	def Result validar(@Body String body) {
		val aux = body.fromJson(ayuda)
		loginApp.nombre = aux.nombre
		loginApp.contrasenia = aux.contrasenia
		try {
			loginApp.validar()
			principalApp = new PantallaPrincipalAplicationModel(loginApp.usuario)
			ok('{ "status" : "OK" }');
		} catch (RuntimeException e) {
			e.printStackTrace()
			internalServerError(e.message)
		}
	}

	@Get('/recetasList')
	def Result recetasList() {
		loginApp.validar()
		principalApp = new PantallaPrincipalAplicationModel(loginApp.usuario)
		response.contentType = ContentType.APPLICATION_JSON
		ok(principalApp.recetasCliente().toJson)
	}

	@Post('/recetasList/')
	def Result agregaroremoverfavorita(@Body String body) {
		val aux = body.fromJson(Receta)
		principalApp.usuario.AgregaroRemoverFavorita(aux.nombreDeLaReceta)
		ok('{ "status" : "OK" }');
	}


	@Post('/buscar/')
	def Result buscar(@Body String body){
		val aux = body.fromJson(CriterioBusqueda)
		principalApp.busquedaUsuario = aux
		principalApp.filtrar()
		principalApp.busquedaUsuario =  new CriterioBusqueda
		ok('{ "status" : "OK" }');	
	}


	@Post('/copiarReceta/')
	def Result copiar(@Body String body) {
		val aux = body.fromJson(infoCopia)
		val nombre = aux.nombre
		val app = new CopiarRecetaAplicationModel(principalApp.devolverReceta(nombre), principalApp.usuario)
		app.nombreCopia = aux.nombreCopia
		try {
			app.copiar()
			principalApp.establecerRecetas()
			ok('{ "status" : "OK" }');
		} catch (RuntimeException e) {
			e.printStackTrace()
			internalServerError(e.message)
		}
	}
}

@Accessors
class ayuda {
	String nombre
	String Contrasenia
}

@JsonIgnoreProperties(ignoreUnknown=true)
@Accessors
class infoCopia {
	String nombre
	String nombreCopia
}