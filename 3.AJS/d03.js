
var app = angular.module("abc", ["ngRoute"]);
app.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            // templateUrl: "main.htm"
        })
        .when("/list", {
            templateUrl: "d03_route_list.html"
        })
        .when("/add", {
            templateUrl: "d03_route_add.html"
        })
        .when("/contact", {
            // templateUrl: "d02_route_ngRepeat.html"
        });
});


//lap trinh cho ung dung app, tim doc du lieu tu tap tin [d03_data.json] va luu vo bien [data] (pham vi ung ung)
app.run(function ($rootScope, $http) {
    $rootScope.data = [];
    $http.get("d03_data.json").then(function (r) {
        $rootScope.data = r.data.modules;
    })
});


//lap trinh cho controller [controlData] cua file [d03_route_list.html]
app.controller("controlData", function ($scope) {
    $scope.remove = function(id){
        //id: ma mon hoc muon xoa khoi danh sach [data]
        if(confirm('Are u sure ?')){
            //dong y xoa mon hoc co ma so id

            //1. tim vi tri index cua mon hoc muoc xoa trong mang [data]
            let index = -1;
            $scope.data.forEach((item, i)=>{
                if(item.id==id){
                    index = i;
                }
            });

            //2. xoa mon hoc tai vi tri index 
            if(index >=0){
                $scope.data.splice(index,1);
            }
        }
    }
});

//lap trinh cho controller [controlADD] cua file [d03_route_add.html]
app.controller("controlADD", function ($scope) {
    $scope.add = function () {
        
        //tao bien json [mh] chua noi dung cua mon hoc moi duoc nhap tren tren form [formADD]
        let mh = {
            "id": $scope.moduleID,
            "name": $scope.moduleName,
            "hours": $scope.hour,
            "fee": $scope.fee
        }

        //luu bien mh vo mang [data]
        $scope.data.push(mh);
        alert("success !");
    }
});


