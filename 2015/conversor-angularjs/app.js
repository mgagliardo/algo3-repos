'use strict';
var conversorApp = angular.module('conversorApp', 	[]);

conversorApp.controller('convesorCtrl', function() { 
	return new Conversor();
});