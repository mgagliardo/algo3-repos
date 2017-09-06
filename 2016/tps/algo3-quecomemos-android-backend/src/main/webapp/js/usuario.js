function Usuario(nom,contra){
	this.nombre = nom;
	this.contrasenia = contra;
}

Usuario.asUsuario = function (jsonUsuario) {
	  return angular.extend(new Usuario(), jsonUsuario);
};
