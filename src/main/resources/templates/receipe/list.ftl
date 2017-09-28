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


    <link rel="stylesheet" href="/popup/magnific-popup.css">
    <script src="/popup/jquery.magnific-popup.js"></script>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/font-awesome-4.7.0/css/font-awesome.css">
    <script>
        $(document).ready(function () {

            $('.image001').magnificPopup({
                type: 'image',
                closeOnContentClick: true,
                closeBtnInside: false,
                fixedContentPos: true,
                mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
                image: {
                    verticalFit: true
                },
                zoom: {
                    enabled: true,
                    duration: 300 // don't foget to change the duration also in CSS
                }
            });
        });

    </script>
</head>
<body >


<div class="container">
    <div class="header">
        리시피 list<br/>

        <a href="./write.ftl">write</a>
    </div>
    <div class="content">
    <#--[{ID=7, title=sadfsdf, material=sdfsdaf, image=banana.jpg, url=sadffsd, create_dt=2017-09-28}-->
        <table class="table table-hover">
        <#list arrList as arrOne>
            <tr>
                <table border="1">
                    <tr>
                        <th>아이디</th>
                        <td style="width: 500px">${arrOne.ID}</td>
                    </tr>
                    <tr>
                        <th>title</th>
                        <td>${arrOne.title}</td>
                    </tr>
                    <tr>
                        <th>material</th>
                        <td>${arrOne.material}</td>
                    </tr>
                    <tr>
                        <th>url</th>
                        <td><a href="${arrOne.url}">${arrOne.url}</a></td>
                    </tr>
                    <tr>
                        <th>image</th>
                        <td>


                            <a class="image001" style="width: 50%;height: 50%" href="/receipeImage/${arrOne.image}" title="${arrOne.title}">
                                <img class="" style="width: 150px;height: 150px;" src="/receipeImage/${arrOne.image}">
                            </a>
                        </td>
                    </tr>

                </table>
                <table>
                    <tr>
                        <td>
                            &nbsp;
                        </td>
                    </tr>

                </table>



            </tr>
        </#list>
        </table>

    </div>



    <!-- The Modal -->
    <div id="myModal" class="modal">

        <!-- The Close Button -->
        <span class="close" onclick="document.getElementById('myModal').style.display='none'">&times;</span>

        <!-- Modal Content (The Image) -->
        <img class="modal-content" id="img01">

        <!-- Modal Caption (Image Text) -->
        <div id="caption"></div>
    </div>
</body>


</html>