var apuestasApp = angular.module('apuestasApp', ['ui.bootstrap']);

apuestasApp.controller('apuestasCtrl', function() {
    this.apuesta = new Apuesta();
    this.tiposApuesta = [ new Pleno(), new Docena() ];
    this.fechaMinimaApuesta = new Date();

    this.verCalendario = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        this.calendarioAbierto = true;
    };
});
