(function() {
	var app = angular.module("appModule", []);

	app.service("appService", function(myConfig, $q, $http, $log, $msgbox) {
		var service = {
			obtenerUsuario : obtenerUsuario,
			obtenerUsuarioActual : obtenerUsuarioActual,
			esUsuarioValido : esUsuarioValido
		};
		return service;

		function obtenerUsuario(nombre) {
			var deferred = $q.defer();
			var url = myConfig.hostEndpoints[myConfig.ambiente] + "/app/obtenerUsuario?nombre=" + nombre;

			$http.get(url).then(function successCallback(response) {
				deferred.resolve(response.data);
			}, function errorCallback(response) {
				console.log("No se pudo obtener los datos por el siguiente problema:");
				console.log(response);
				deferred.reject(response);
			});
			return deferred.promise;
		}
		;

		function obtenerUsuarioActual() {
			var deferred = $q.defer();
			var url = myConfig.hostEndpoints[myConfig.ambiente] + "/app/obtenerUsuarioActual";

			$http.get(url).then(function successCallback(response) {
				deferred.resolve(response.data);
			}, function errorCallback(response) {
				console.log("No se pudo obtener los datos por el siguiente problema:");
				console.log(response);
				deferred.reject(response);
			});
			return deferred.promise;
		}
		;

		function esUsuarioValido(usuario) {
			return (!(usuario && usuario.name && usuario.roles));
		}
	});
})();