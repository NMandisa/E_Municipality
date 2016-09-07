/**
 * Created by NMandisa MKhungo on 7/28/2016.
 */
var baseUrl = "http://localhost:8081";
var app = angular.module('myApp', ['ui.router']);
app.config(function ($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/login");
    // Now set up the states
    $stateProvider
        .state('login', {
            url: "/login",
            templateUrl: "partials/login.html",
            controller: "myCtrl"
        })
        .state('signup', {
            url: "/signup",
            templateUrl: "partials/register.html",
            controller: "myCtrl"
        })
        .state('layout.faultlog', {
            url: "/faultlog",

            templateUrl: "partials/fault-logging.html",
            controller: "FaultLogCtrl"
        })
        .state('forgotpassword', {
            url: "/forgotpassword",
            templateUrl: "partials/forgot-password.html",
            controller: ""
        })
        .state('layout.search-results', {
            url: "/search",
            templateUrl: "partials/search-results.html",
            controller: "SearchCtrl"
        })
        .state('report-fault', {
            url: "/report",
            parent : "layout",
            templateUrl: "partials/report-fault.html",
            controller: "ReportFaultCtrl"
        })
        .state('dashboard', {
            url: "/dashboard",
            templateUrl: "partials/home.html",
            parent : "layout",
            controller: "DashboardCtrl"
        })
        .state('user', {
            url: "/dashboard",
            templateUrl: "partials/home.html",
            parent : "layout",
            controller: "DashboardCtrl"
        })
        .state('layout', {
            url: "",
            templateUrl: 'app-layout.html',
            controller: 'DashboardCtrl',
            abstract: true,
            resolve: {
                //result_data: function ($q, $timeout)//,CommonService)
                //{
                //    //return resolve_homepage($q,CommonService)
                //    var deferred = $q.defer();
                //    $timeout(function(){
                //        deferred.resolve("from a parent");
                //    }, 500);
                //    return deferred.promise;
                //}
            }
        });
    //.state('state1.list', {
    //    url: "/list",
    //    templateUrl: "partials/state1.list.html",
    //    controller: function($scope) {
    //        $scope.items = ["A", "List", "Of", "Items"];
    //    }
    //})
    //.state('state2.list', {
    //    url: "/list",
    //    templateUrl: "partials/state2.list.html",
    //    controller: function($scope) {
    //        $scope.things = ["A", "Set", "Of", "Things"];
    //    }
    //})

});
app.controller('myCtrl', function ($scope, $http, $window, $location) {


    $scope.users = [];
    $scope.regSuccess;
    $scope.regError;
    $scope.loginSuccess;
    $scope.loginError;
    $scope.loggedUser = {};
    console.log('In get ALL user');

    $scope.submitForm = function (isValid) {
        console.log("validating form");
        // check to make sure the form is completely valid
        if (isValid) {
            console.log('our form is amazing');
        }
    }
    $scope.addUser = function () {
        console.log('In add user');
        // function to submit the form after all validation has occurred

        var dataObj = {
            "idNumber": $scope.uidNumber,
            "firstName": $scope.uname,
            "surname": $scope.usurname,
            "address": $scope.uaddress,
            "city": $scope.ucity,
            "postalCode": $scope.ucode,
            "gender": $scope.ugender,
            "password": $scope.upassword,
            "emailAddress": $scope.uemail
        };
        var parameter = JSON.stringify(dataObj);
        $http({
            method: 'post',
            url: baseUrl + "/users/create",
            data: parameter
        }).then(function successCallback(response) {
            console.log('Success'); //+ response.data);
            $scope.regSuccess = true;

            console.log('response == OK');

            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('Failed' + response);
            $scope.regError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };

    $scope.loginUser = function () {
        console.log('in login method');
        var dataObjUser;
        dataObjUser= {
            "password": $scope.lpassword,
            "emailAddress": $scope.lemail
        };
        var parameter = JSON.stringify(dataObjUser);
        $http({
            method: 'post',
            url: baseUrl + "/users/login",
            data: parameter
        }).then(function successCallback(response) {
            console.log('Success');
            $scope.loggedUser = response.data;
            console.log("Logged In User" + JSON.stringify(response.data));
            console.log(response.data);
            console.log($scope.loggedUser);
            //successCallback(response.data, response.status, response.headers);
            $scope.loginSuccess = true;

            console.log('response == OK');
            $location.path('/dashboard');
            //$window.location.href = '/E_Municipality/templates/home.html';
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('Failed' + response);
            $scope.loginError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };




});
app.controller('SearchCtrl', function ($scope, $http) {
    $scope.searchResult = [];
    $scope.searchFault = function () {
        console.log('in searchFault method');
        var dataObj = {
            "faultStatus": $scope.qFaultStatus
        };
        var parameter = JSON.stringify(dataObj);
        $http({
            method: 'post',
            url: baseUrl + "/faults/search",
            data: parameter
        }).then(function successCallback(response) {
            console.log('searchFault Success');
            //successCallback(response.data, response.status, response.headers);
            console.log(response.data);
            $scope.searchResult = response.data;

            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('searchFault Failed' + response);
            $scope.loginError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };

    $scope.getSearchFault = function () {
        console.log('in get searchFault method');
        $http({
            method: 'get',
            url: baseUrl + "/faults/getSearch",
            data: null
        }).then(function successCallback(response) {
            console.log('get searchFault Success');
            console.log(response.data);
            $scope.searchResult = response.data;
            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('get searchFault Failed' + response);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };

});
app.controller('DashboardCtrl', function ($scope, $http) {
    $scope.getLoginUser = function () {
        console.log('in get login method');
        $http({
            method: 'get',
            url: baseUrl + "/users/getLogin",
            data: null
        }).then(function successCallback(response) {
            console.log('Success');
            $scope.loggedUser = response.data;
            console.log(response.data);
            console.log($scope.loggedUser);
            $scope.loginSuccess = true;
            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('Failed' + response);
            $scope.loginError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };
});
app.controller('ReportFaultCtrl', function ($scope, $http) {
    $scope.faultSuccess;
    $scope.faultError;
    $scope.loadFaultCategory = function () {
        console.log('in loadFaultCategory method');

        $http({
            method: 'get',
            url: baseUrl + "/faultsCategory/"
            //data: null
        }).then(function successCallback(response) {
            console.log('loadFaultCategory Success'); //+ response.data);
            console.log(response.data);
            $scope.availCategory = response.data;

            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('loadFaultCategory Failed' + response);
            $scope.loginError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };
    $scope.addFault = function () {
        $scope.availCategory = [];
        console.log('In add Fault');
        console.log("function to submit the form after all validation has occurred");
        var location = $scope.uaddress + ',' + $scope.ucity + ', ' + $scope.ucode;
        console.log($scope.loggedUser);
        var loguserid = $scope.loggedUser.userId;
        console.log('In add UserID '+$scope.loggedUser.userId);
        //console.log($scope.loggedUser.userId, loggedUser.firstName);
        var dataObj = {
            "userId": loguserid,
            "faultCategoryId": $scope.faultCatId,
            "faultDesc": $scope.lfaultDesc,
            "faultTime": "10/August/2016",
            "faultStatus": "Open",
            "location": location
        };
        var parameter = JSON.stringify(dataObj);
        $http({
            method: 'post',
            url: baseUrl + "/faults/create",
            data: parameter
        }).then(function successCallback(response) {
            console.log('Success');
            $scope.faultSuccess = true;
            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('Failed' + response);
            $scope.faultError = true;
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });


    };


});
app.controller('FaultLogCtrl', function ($scope, $http) {

    $scope.faultLog = function () {
        $scope.userFaults=[];
        console.log('In fault Log');
        console.log("function to submit the form after all validation has occurred");

        var loguserid = $scope.loggedUser.userId;
        console.log(loguserid);
        console.log('In fault Log UserID '+loguserid);
        //console.log($scope.loggedUser.userId, loggedUser.firstName);

        $http({
            method: 'post',
            url: baseUrl + "/faults/track/"+loguserid,
        }).then(function successCallback(response) {
            console.log('Success');
            $scope.userFaults=response.data;
            console.log(response.data);
            console.log('response == OK');
            // this callback will be called asynchronously
            // when the response is available
        }, function errorCallback(response) {
            console.log('Failed' + response);
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });


    };


});




