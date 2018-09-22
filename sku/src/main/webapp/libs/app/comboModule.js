(function() {
	var app = angular.module("comboModule", []);

	app.service("comboService", function(myConfig, $q, $http, $log, utilsService) {
		var service = {
			save : save,
			findAll : findAll,
			enums : {
			}
		};

		enums();

		return service;

		function save(combo) {
			var deferred = $q.defer();
			var url = myConfig.hostEndpoints[myConfig.ambiente] + '/combo/save';

			$http.post(url, combo).then(function successCallback(response) {
				deferred.resolve(response.data);
			}, function errorCallback(response) {
				$log.error("No se pudo obtener los datos por el siguiente problema:", response);
				$log.error(response);
				deferred.reject(response);
			});
			return deferred.promise;
		}
		
		function findAll() {
			var deferred = $q.defer();
			var url = myConfig.hostEndpoints[myConfig.ambiente] + '/combo/findAll';

			$http.get(url).then(function successCallback(response) {
				deferred.resolve(response.data);
			}, function errorCallback(response) {
				$log.error("No se pudo obtener los datos por el siguiente problema:", response);
				$log.error(response);
				deferred.reject(response);
			});
			return deferred.promise;
		}

		function enums() {		
			
		}
	});

	app.directive('comboMenu', function() {
		return {
			restrict : 'A',
			templateUrl : 'pages/combo/menu.html',
		}
	});

	app.directive('altaComboForm', function($filter, $msgbox, $uibModal, uiGridConstants, utilsService, comboService) {
		return {
			restrict : 'A',
			templateUrl : 'pages/combo/alta.html',
			link : function(scope, element, attrs) {
				var vm = scope;

				vm.combo = undefined;
				vm.enums = comboService.enums;

				vm.save = function() {
					comboService.save(vm.combo).then(function(data) {
						alert("Se ha grabado correctamente el combo");
					}, function(error) {
						FuncionesError.generarAngularMsgboxSimple($msgbox, error);
					});
				}
			}
		}
	});
	
	app.directive('consultaComboForm', function($filter, $msgbox, $uibModal, uiGridConstants, utilsService, comboService) {
		return {
			restrict : 'A',
			templateUrl : 'pages/combo/consulta.html',
			link : function(scope, element, attrs) {
				var vm = scope;

				vm.enums = comboService.enums;
				
				vm.gridApi = {};
				vm.gridOptions = {
					enableFiltering : true,
					enableGridMenu : true,
					enableSorting : true,
					onRegisterApi : function(gridApi){
						vm.gridApi = {};
					},
					columnDefs : [
						{
							displayName : 'SKU',
							field : 'sku',
							type : 'text',
							width : '10%',
							visible : true
						},
						{
							displayName : 'Nombre',
							field : 'nombre',
							type : 'text'
						}
					]
				};

				vm.findAll = function() {
					comboService.findAll().then(function(data) {
						//vm.combos = data;
						vm.gridOptions.data = data;
					}, function(error) {
						FuncionesError.generarAngularMsgboxSimple($msgbox, error);
					});
				};
				
				vm.findAll();
			}
		}
	});

	app.config(function($routeProvider) {
		$routeProvider.when("/combo/alta", {
			template : "<div alta-combo-form></div>"
		}).when("/combo/consulta", {
			template : "<div consulta-combo-form></div>"
		});
	});
})();