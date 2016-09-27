'use strict';
var conversorApp = angular.module('conversorApp', []);

conversorApp.controller('conversorCtrl', function() {
  return new Conversor();
});
