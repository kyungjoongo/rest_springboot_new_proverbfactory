<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>래시피 입력하기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/bt4.css">
    <link rel="stylesheet" href="/css/style.css">


    <script src="/js/jquery2.js"></script>
    <script src="/js/angularjs1.6.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/font-awesome-4.7.0/css/font-awesome.css">
    <script>
        $(document).ready(function () {

            alert('sdlfksdlkflsdkf');
        });

    </script>
</head>
<body ng-app="helloApp" ng-controller="HelloCtrl">


<div class="container">
    <div class="header">
        리시피 입력하기
    </div>
    <div class="content">
    <#--[{ID=7, title=sadfsdf, material=sdfsdaf, image=banana.jpg, url=sadffsd, create_dt=2017-09-28}-->
        <table class="table">
        <#list arrList as arrOne>
            <tr>
                <td>${arrOne.title}</td>
                <td>${arrOne.material}</td>
                <td><img style="width: 300px;height: 300px;" src="/receipeImage/${arrOne.image}"></td>
            </tr>
        </#list>
        </table>

    </div>


</body>


</html>