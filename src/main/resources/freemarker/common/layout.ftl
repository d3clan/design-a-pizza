<#macro page title="Design-a pizza" activeNav="home">
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="<@spring.url '/resources/css/bootstrap.css'/>" rel="stylesheet" media="screen">
    <link href="<@spring.url '/resources/css/bootstrap-responsive.css'/>" rel="stylesheet" media="screen">
    <link href="<@spring.url '/resources/css/bootstrap-select.css'/>" rel="stylesheet" media="screen">
    <link href="<@spring.url '/resources/css/styles.css'/>" rel="stylesheet" media="screen">

    <script src="<@spring.url '/resources/js/jquery.js'/>"></script>
    <script src="<@spring.url '/resources/js/jquery-ui.js'/>"></script>
</head>
<body>
<div class="container">
<#include "/common/navbar.ftl"/>
<#nested />
<#include "/common/footer.ftl"/>
</div>
</body>
</html>
</#macro>