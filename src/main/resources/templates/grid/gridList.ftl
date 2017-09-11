<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>k</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
            integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
            integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
            integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
            crossorigin="anonymous"></script>
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
</head>
<body>

<div class="table-responsive">
    <table class="table table-striped" style="font-size: 12pt;font-weight: bold" border="1">
        <tr>
            <td> sdlfksdlkflsdkflsk
                한번만 더 내면 쫐아가서 혼내준다 썅년
                씨발년 그롯소asdsdfsdfsdfsasdasdasd리좀 그만내 썅년아
            </td>
            <Td>
                sdlfksldkflsk333
            </Td>

        </tr>

    </table>
    <div class="container">

    <#list proverbList as proverbOne>

        <!--처음행인경우 start <div> -->
        <#if (proverbOne?index % 3) == 0>
            <div class="row" style="border: 1">
        </#if>

        <div class="col-md-4">
            ${proverbOne.id}
            ${proverbOne.content}
        </div>


        <!--마지막행인경우 close <div> -->
        <#if (proverbOne?index % 3) == 2>
            </div>
        </#if>


        </tr>
    </#list>


    </div>
</body>


</html>