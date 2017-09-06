package ar.tp.dieta

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors


@Accessors
public class RepositorioUsuarios extends RepoRecetas{
	
	private static RepositorioUsuarios instance
	
	List<Usuario> usuarios
	ContadorConsultas observer = new ContadorConsultas
	RecetarioPublico recetario = new RecetarioPublico
	RutinaActiva basket = new RutinaActiva
	public Usuario juan
	public Usuario gabriel
	public Usuario miguel
	public Usuario carlos
	public Usuario manuel
	public Usuario daniel
	public Usuario tempUser
	
	Busqueda busquedaFiltrada = new Busqueda
	
	
	
	new(){
		busquedaFiltrada.agregarFiltro(new FiltroPorIngredienteCaro)
		usuarios = new ArrayList<Usuario>
		//new RepoRecetas

		basket.setTiempoDeEjercicio(240)		
		gabriel = new UsuarioBuilder("Gabriel","gabriel").peso(90.5).altura(1.90).fechaNacimiento(1985, 6, 12).sexo("M").condicion(new CondicionCeliaco).preferencia("fruta").email("gabriel@edrans.com").build()
		manuel = new UsuarioBuilder("Manuel","manuel").peso(120.5).altura(1.85).fechaNacimiento(1982, 1, 25).sexo("M").rutina(basket).condicion(new CondicionVegano).preferencia("carne").email("manuel@edrans.com").build()
		miguel = new UsuarioBuilder("Miguel","miguel").peso(70.5).altura(1.73).fechaNacimiento(1989, 5, 18).sexo("M").condicion(new CondicionHipertension).preferencia("fruta").email("miguel@edrans.com").build()
		daniel = new UsuarioBuilder("Daniel","daniel").peso(100.5).altura(1.95).fechaNacimiento(1995, 6, 28).sexo("M").rutina(basket).preferencia("pescado").email("daniel@edrans.com").build()
		juan = new UsuarioBuilder("Juan","juan").peso(75.5).altura(1.87).fechaNacimiento(1993, 1, 28).sexo("M").preferencia("fruta").email("juan@edrans.com").build()
	
		usuarios.add(gabriel)
		usuarios.add(miguel)
		usuarios.add(manuel)
		usuarios.add(juan)
		usuarios.add(daniel)

		daniel.agregarRecetaFavorita(ensalada)
		
		usuarios.forEach[usuario | usuario.observerConsulta = observer]
		usuarios.forEach[usuario | usuario.recetario = recetarioPublico]

		miguel.crearReceta("Pastel de papa", 1500, "Gabriel", "Mediana", "Hervir la papa, sellar la carne picada, mezclar ambas en una fuente y poner durante 40 minutos en el horno", "Todo el año", new IngredienteBuilder("carne").cantidad(500).build(), new IngredienteBuilder("papa").cantidad(300).build())
		miguel.crearReceta("Fideos con Tuco", 400, "Gabriel", "Facil", "Hervir los fideos, mezclar con la salsa de tomate caliente.", "Todo el año", new IngredienteBuilder("fideos").cantidad(200).build(), new IngredienteBuilder("tomate").cantidad(300).build())

		daniel.agregarRecetaFavorita(ensalada)
		daniel.agregarRecetaFavorita(asado)
		
		manuel.crearReceta("Bizcochuelo", 600, "Manuel", "Facil", "Mezclar un sobre de exquisita con leche. Hornear con horno al maximo durante 40 minutos", "Todo el año", new IngredienteBuilder("bizcochuelo").cantidad(300).build(), new IngredienteBuilder("azucar").cantidad(250).build())
		manuel.crearReceta("Vigilante", 300, "Manuel", "Facil", "Cortar una feta de queso y una del dulce que mas te guste, comer ambos juntos.", "Todo el año", new IngredienteBuilder("Queso").cantidad(50).build(), new IngredienteBuilder("Dulce de Membrillo").cantidad(50).build())
		
		usuarios.get(1).agregarBusqueda(busquedaFiltrada)
		usuarios.get(1).busquedaFiltrada()
	}
	
		
	def validarLogin(String username, String password) {
		return this.buscarUsuario(username, password)
 	}

 	def buscarUsuario(String user, String key){
 		tempUser = null;
		usuarios.forEach[ usuario | if(usuario.getNombre.equals(user) && usuario.contrasenia.equals(key)){
										tempUser = usuario
									}
		]
		if (tempUser !=null){
			return tempUser
		}else{
			throw new RuntimeException("Usuario y/o contraseña incorrectos")
		}
		
	}
	

}