var app = angular.module('dynamictemp', []);
app.directive('loanDetailForm', function ($templateCache, $compile) {
    var getTemplate = function (loanType) {
        var t;
        switch (loanType) {
            case "1":
                t = $templateCache.get("template1");
                break;
            case "2":
                t = $templateCache.get("template2");
                break;
            default:
                t = "<div>No loan type selected</div>";
        }
        return t;
    }
    return {
        restrict: 'E',
        scope: {
            loan: "="
        },
        link: function (scope, elem, attrs) {
            scope.$watch('loan.loanType', function (newVal) {
                elem.html(getTemplate(newVal));
                $compile(elem.contents())(scope);
            });
        }
    }
})
app.controller('MainCtrl', function ($scope) {
    $scope.model = {
        loanType: "1",
        attributeA: "Photo ID Documents",
        attributeB: "Address Proof",
        attributeC: "Salary Slip"
    }
}); 