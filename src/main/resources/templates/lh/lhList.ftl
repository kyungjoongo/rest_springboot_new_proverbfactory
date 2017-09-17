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


        var pageIndex = '${pageIndex}';


        var helloApp = angular.module("helloApp", []);

        helloApp.controller("HelloCtrl", function ($scope, $http, $compile) {
            //$scope.name = "고경준 천재님이십니다sdlfksldkflsdkf Hobbes";

            $http({
                method: "post",
                url: "/lh/lhListToJson?pageIndex=" + pageIndex
            }).then(function mySuccess(response) {

                $scope.arrList = response.data.resultList;


                $scope.pageIndex = pageIndex;
                $scope.nextPage = parseInt(pageIndex) + 1;
                $scope.prevPage = parseInt(pageIndex) - 1;


                $scope.totalPage = response.data.resultCnt;


            }, function myError(response) {
                $scope.myWelcome = response.statusText;
            });

            $scope.range = function (min, max, step) {
                step = step || 1;
                var input = [];
                for (var i = min; i <= max; i += step) {
                    input.push(i);
                }
                return input;
            };

            $scope.submit1 = function (srchsignguCode, srchbrtcCode) {

                $http({
                    method: "post",
                    url: "/lh/lhListToJson?pageIndex=" + pageIndex + "&srchsignguCode=" + srchsignguCode + "&srchbrtcCode=" + srchbrtcCode
                }).then(function mySuccess(response) {

                    $scope.arrList = response.data.resultList;


                    var result = response.data.resultList;

                    console.log(JSON.stringify(result));


                    $scope.pageIndex = pageIndex;
                    $scope.nextPage = parseInt(pageIndex) + 1;
                    $scope.prevPage = parseInt(pageIndex) - 1;


                    $scope.totalPage = response.data.resultCnt;


                }, function myError(response) {
                    $scope.myWelcome = response.statusText;
                });
            }


        });

        helloApp.filter('roundup', function () {
            return function (value) {
                return Math.ceil(value);
            };
        })

        helloApp.filter('dateKor', function () {
            return function (date) {

                var year = date.substring(0, 4);
                var month = date.substring(4, 6);
                var day = date.substring(6, 8);
                var time = date.substring(8, 10);
                var time2 = date.substring(10, 12);

                //alert year;


                return year + "-" + month + "-" + day + "    " + time + ":" + time2;
            };
        })

    </script>
</head>
<body ng-app="helloApp" ng-controller="HelloCtrl">


<div class="container">
    <div class="header">
        임대주택 찾기
    </div>

    <div>

        <table class="table" border="1">

            <thead>

            <th>curPage: {{pageIndex}}</th>
            <Th> {{totalPage}}</Th>

            </thead>
        </table>
        <table>
            <tr>
                <td>
                    <form id="form1" ng-submit="submit1(location, srchbrtcCode)">

                        state :<select ng-model="srchbrtcCode">
                        <option value="11">서울</option>
                        <option value="41">경기도</option>
                    </select>

                        지역명 :<select ng-model="location">
                        <option value="680">강남구</option>
                        <option value="710">송파구</option>
                        <option value="650">서초구</option>
                        <option value="135">분당</option>
                    </select>
                        <input type="submit" id="submit" value="검색">
                    </form>
                </td>

            </tr>

        </table>

        <table class="table" border="1">

            <thead class="thead-inverse">
            <tr>
                <th width="50%">

                    <a ng-if="pageIndex > 1" href="/lh/lhList?pageIndex={{prevPage}}">prevPage</a>
                </th>
                <th width="50%">
                    <a href="/lh/lhList?pageIndex={{nextPage}}">nextPage</a>
                </th>

            </tr>
            </thead>

        </table>

        <table class="table" border="1">

            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>지역</th>
                <th>공고명</th>
                <th>등록일</th>
                <th>완료여부</th>
            </tr>
            </thead>

            <tbody>

            <tr class="col-md-4" ng-repeat="map in arrList">

                <td> {{map.rn}}</td>
                <td width="120px;">
                    {{map.brtcCodeNm}}
                </td>

                <td width="250px;">
                    {{map.pblancNm}}
                </td>
                <td>
                    {{map.frstRegistDt | dateKor }}
                </td>
                <td ng-class="{'table-danger': map.prgrStts.trim() =='모집중'}">
                    {{map.prgrStts}}
                </td>


            </tr>
            </tbody>

        </table>


    </div>


</body>


</html>