app.controller('LoginController',function(Service, $state, $timeout) {
    
    
    var self = this;
    this.errors= [];
    this.infologin = new Usuario();


    function notificarError(mensaje) {
          self.errors.push(mensaje.data);
        $timeout(function() {
            while(self.errors.length > 0) self.errors.pop();
        }, 5000);
       };

    this.logear = function() {
        Service.logear(this.infologin, function() {
            $state.go("recetas");
        },notificarError);

    };

   
    

});