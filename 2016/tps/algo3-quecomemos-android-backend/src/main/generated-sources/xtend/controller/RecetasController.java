package controller;

import appModel.CopiarRecetaAplicationModel;
import appModel.PantallaLoginAplicationModel;
import appModel.PantallaPrincipalAplicationModel;
import ar.tp.dieta.CriterioBusqueda;
import ar.tp.dieta.Receta;
import ar.tp.dieta.RecetaCliente;
import ar.tp.dieta.Usuario;
import controller.ayuda;
import controller.infoCopia;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.XTRest;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class RecetasController extends ResultFactory {
  public PantallaLoginAplicationModel loginApp = new PantallaLoginAplicationModel();
  
  public PantallaPrincipalAplicationModel principalApp;
  
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  public static void main(final String[] args) {
    XTRest.start(RecetasController.class, 9000);
  }
  
  @Post("/login/")
  public Result validar(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final ayuda aux = this._jSONUtils.<ayuda>fromJson(body, ayuda.class);
      String _nombre = aux.getNombre();
      this.loginApp.setNombre(_nombre);
      String _contrasenia = aux.getContrasenia();
      this.loginApp.setContrasenia(_contrasenia);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          this.loginApp.validar();
          PantallaPrincipalAplicationModel _pantallaPrincipalAplicationModel = new PantallaPrincipalAplicationModel(this.loginApp.usuario);
          this.principalApp = _pantallaPrincipalAplicationModel;
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof RuntimeException) {
          final RuntimeException e = (RuntimeException)_t;
          Result _xblockexpression_2 = null;
          {
            e.printStackTrace();
            String _message = e.getMessage();
            _xblockexpression_2 = ResultFactory.internalServerError(_message);
          }
          _xtrycatchfinallyexpression = _xblockexpression_2;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  @Get("/recetasList")
  public Result recetasList(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      this.loginApp.validar();
      PantallaPrincipalAplicationModel _pantallaPrincipalAplicationModel = new PantallaPrincipalAplicationModel(this.loginApp.usuario);
      this.principalApp = _pantallaPrincipalAplicationModel;
      response.setContentType(ContentType.APPLICATION_JSON);
      RecetaCliente _recetasCliente = this.principalApp.recetasCliente();
      String _json = this._jSONUtils.toJson(_recetasCliente);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Post("/recetasList/")
  public Result agregaroremoverfavorita(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final Receta aux = this._jSONUtils.<Receta>fromJson(body, Receta.class);
      Usuario _usuario = this.principalApp.getUsuario();
      String _nombreDeLaReceta = aux.getNombreDeLaReceta();
      _usuario.AgregaroRemoverFavorita(_nombreDeLaReceta);
      _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
    }
    return _xblockexpression;
  }
  
  @Post("/buscar/")
  public Result buscar(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final CriterioBusqueda aux = this._jSONUtils.<CriterioBusqueda>fromJson(body, CriterioBusqueda.class);
      this.principalApp.setBusquedaUsuario(aux);
      this.principalApp.filtrar();
      CriterioBusqueda _criterioBusqueda = new CriterioBusqueda();
      this.principalApp.setBusquedaUsuario(_criterioBusqueda);
      _xblockexpression = ResultFactory.ok("{ \"status\" : \"OK\" }");
    }
    return _xblockexpression;
  }
  
  @Post("/copiarReceta/")
  public Result copiar(@Body final String body, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      final infoCopia aux = this._jSONUtils.<infoCopia>fromJson(body, infoCopia.class);
      final String nombre = aux.getNombre();
      Receta _devolverReceta = this.principalApp.devolverReceta(nombre);
      Usuario _usuario = this.principalApp.getUsuario();
      final CopiarRecetaAplicationModel app = new CopiarRecetaAplicationModel(_devolverReceta, _usuario);
      String _nombreCopia = aux.getNombreCopia();
      app.setNombreCopia(_nombreCopia);
      Result _xtrycatchfinallyexpression = null;
      try {
        Result _xblockexpression_1 = null;
        {
          app.copiar();
          this.principalApp.establecerRecetas();
          _xblockexpression_1 = ResultFactory.ok("{ \"status\" : \"OK\" }");
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof RuntimeException) {
          final RuntimeException e = (RuntimeException)_t;
          Result _xblockexpression_2 = null;
          {
            e.printStackTrace();
            String _message = e.getMessage();
            _xblockexpression_2 = ResultFactory.internalServerError(_message);
          }
          _xtrycatchfinallyexpression = _xblockexpression_2;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/recetasList").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		
    		
    	    Result result = recetasList(target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/login/").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = validar(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/recetasList/").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = agregaroremoverfavorita(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/buscar/").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = buscar(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/copiarReceta/").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		
    		
    	    Result result = copiar(body, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/recetasList</td>"
    	+ "				<td></td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/login/</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/recetasList/</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/buscar/</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/copiarReceta/</td>"
    	+ "				<td>body</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
