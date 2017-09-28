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
<#--title  varchar(255),
material varchar(255),
image varchar(100),
url varchar(255),
-->
    <div class="content">

    <#if message??>
        Hi ${message},
    </#if>
        <form id="form1" action="/receipe/write" method="post" enctype="multipart/form-data">
            <table class="table" border="1">
                <tr>
                    <td>title</td>
                    <td>

                        <input type="text" name="title" id="title">

                    </td>

                </tr>
                <tr>
                    <td>material</td>
                    <td>

                        <input type="text" name="material" id="material">

                    </td>

                </tr>
                <tr>
                    <td>url</td>
                    <td>

                        <input type="text" name="url" id="url">

                    </td>

                </tr>
                <tr>
                    <td>image</td>
                    <td>
                        <input type="file" name="image" id="image">

                    </td>

                </tr>


            </table>
            <input type="submit" value="submit">
    </div>


</body>


</html>