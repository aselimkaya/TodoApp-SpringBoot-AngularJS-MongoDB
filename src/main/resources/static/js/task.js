var myModule = angular.module("TodoApp");

var taskEditController = function (TodoApi, $scope, $location, $routeParams) {
    $scope.save = function (task) {
        var request = TodoApi.saveTask(task);
        request.$promise.then(function () {
            $location.path("/");
        });
    };

    $scope.init = function () {
        var id = $routeParams.id;
        $scope.task = TodoApi.get({id:id});
    };
    $scope.init();
};

var taskListController = function (TodoApi, $scope, $location) {
    $scope.deleteTask = function (taskId, rowIndex){
        TodoApi.get({id:taskId}).$promise.then(function (task) {
            TodoApi.deleteTask(task).$promise.then(function () {
                $scope.taskList.splice(rowIndex, 1);
            });
        });
    };

    $scope.redirect = function(){
        $location.url("/task/addNew");
    };

    $scope.finishTask = function(taskId, done){
        TodoApi.get({id:taskId}).$promise.then(function (task) {
            task.done = done;
            var request = TodoApi.saveTask(task);
            request.$promise.then(function () {
                $location.path("/");
            });
        });
    };

    $scope.editTask = function (task) {
        $location.path("/task/" + task.id);
    };

    $scope.init = function () {
        $scope.taskList = TodoApi.all();
    };
    $scope.init();
};

var addTaskController = function (TodoApi, $scope, $location){
    $scope.save = function (task) {
        var request = TodoApi.saveTask(task);
        request.$promise.then(function () {
            $location.path("/");
        });
    };

    $scope.init = function () {
        $scope.task = {};
    };
    $scope.init();
};

myModule.factory("TodoApi", function ($resource) {
    var baseUrl = "/task/:id";
    return $resource(baseUrl, {},
        {
            all:{
                method: "GET",
                url: baseUrl + "/all",
                isArray: true
            },
            /*getTask:{
                method: "GET",
                params:{
                    id: "@id"
                }
            },*/
            saveTask:{
                method: "POST",
                url: baseUrl + "/add"
            },
            deleteTask:{
                method: "DELETE",
                params:{
                    id: '@id'
                }
            }
        });
});

myModule.component("taskList", {
    templateUrl: "/template/all-tasks.html",
    controller: taskListController
});

myModule.component("taskEdit", {
    templateUrl: "/template/edit-task.html",
    controller: taskEditController
});

myModule.component("addTask", {
   templateUrl: "/template/add-new-task",
   controller: addTaskController
});