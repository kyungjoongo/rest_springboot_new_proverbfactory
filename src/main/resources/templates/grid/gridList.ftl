<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>k</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

    <script src="/js/jquery2.js"></script>
    <script src="/js/angularjs1.6.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/font-awesome-4.7.0/css/font-awesome.css">


    <style>

        /* xs < 768 */
        @media screen and (max-width: 767px) {
            body {
                font-size: 0.9em;
            }
        }

        /* sm */
        @media screen and (min-width: 768px) {
            body {
                font-size: 1em;
            }
        }

        /* md */
        @media screen and (min-width: 992px) {
            body {
                font-size: 1.2em;
            }
        }

        /* lg */
        @media screen and (min-width: 1200px) {
            body {
                font-size: 1.3em;
            }
        }

        body {
            padding-top: 2rem;
            padding-bottom: 2rem;
        }

        h3 {
            margin-top: 2rem;
        }

        .row {
            margin-bottom: 1rem;
        }

        .row .row {
            margin-top: 1rem;
            margin-bottom: 0;
        }

        [class*="col-"] {
            padding-top: 1rem;
            padding-bottom: 1rem;
            background-color: rgba(86, 61, 124, .15);
            border: 1px solid rgba(86, 61, 124, .2);
        }

        hr {
            margin-top: 2rem;
            margin-bottom: 2rem;
        }

    </style>
    <script>
        $(document).ready(function () {
            $(".fa-heart").on("click", function () {
                var id = $(this).attr("id");
                // alert(id);

                var _content = $("#content" + id).html();

                alert(_content);
            });
        });

        var helloApp = angular.module("helloApp", []);

        helloApp.controller("HelloCtrl", function ($scope, $http, $compile) {
            //$scope.name = "고경준 천재님이십니다sdlfksldkflsdkf Hobbes";

            $http({
                method: "post",
                url: "/grid/gridListJson"
            }).then(function mySuccess(response) {

                $scope.arrList = response.data.arrList;


            }, function myError(response) {
                $scope.myWelcome = response.statusText;
            });

           // $compile('<div>{{caption}}</div>')($scope);

            $scope._row= "<div class='row'>";

            $scope._row2= "</div>";





        });


    </script>
</head>

<body ng-app="helloApp">


<div class="container">

    <div ng-controller="HelloCtrl">

            <div class="col-md-4" ng-repeat="x in arrList">


                <div ng-if="$index % 3 ==0">
                    <p ng-bind-html="_row"></p>
                </div>


                <div class="col">{{x.id}} {{x.content}}</div>
                <div class="col" style="text-align: right"><i class="fa fa-heart" aria-hidden="true"></i>

                    <div ng-if="$index % 3 ==2">
                        <p ng-bind-html="_row2"></p>
                    </div>

            </div>


        </div>

    <#--

    <#list proverbList as proverbOne>

        <!--처음행인경우 start <div> &ndash;&gt;
        <#if (proverbOne?index % 3) == 0>
        <div class="row" style="border: 1">
        </#if>

        <div class="col-md-4">

            <div class="col" id="content${proverbOne.id}">${proverbOne.id}   ${proverbOne.content}</div>
            <div class="col">&nbsp;</div>
            <div class="col" style="text-align: right"><i class="fa fa-heart" aria-hidden="true"
                                                          id="${proverbOne.id}"></i></div>

        </div>


        <!--마지막행인경우 close <div> &ndash;&gt;
        <#if (proverbOne?index % 3) == 2>
        </div>
        </#if>


        </tr>
    </#list>-->


    </div>
</body>


</html>