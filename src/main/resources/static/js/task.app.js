var app = angular.module("TodoApp", [
    'ngRoute',
    'ngResource',
    'ui.bootstrap'
]);

app.config(["$routeProvider", "$locationProvider", function ($routeProvider, $locationProvider) {
    $routeProvider.when("/", {
        template: "<task-list></task-list>"
    }).when("/task/:id", {
        template: "<task-edit></task-edit>"
    }).when("/task/addNew", {
        template: "<add-task></add-task>"
    }).otherwise({
        redirectTo: "/"
    });

    $locationProvider.html5Mode({enabled: true});
}]);