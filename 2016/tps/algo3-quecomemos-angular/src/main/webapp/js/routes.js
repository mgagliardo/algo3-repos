app.config(function ($stateProvider, $urlRouterProvider) {

 $urlRouterProvider.otherwise("/");

 $stateProvider

  .state('recetas', {
     url: "/recetas",
     templateUrl: "partials/pantallaPrincipal.html",
     controller: "RecetasController as recetaCtrl"
   })

   .state('detalleReceta', {
     url: "/receta/:nombre",
     templateUrl: "partials/detalleReceta.html",
     controller: "detalleRecetaController as detalleRecetaCtrl",
   })

   .state('login',{
    url: "/",
    templateUrl: "partials/login.html",
    controller: "LoginController as loginCtrl"
   })

   .state('copiarReceta',{
    url: "/copiarReceta",
    templateUrl: "partials/copiarReceta.html",
    controller: "CopiarRecetaController as copiaCtrl"
   });

});
