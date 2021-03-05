<html>
<head>
    <title>Latest</title>
</head>

<body>
<#list responses as list>
    <span>
        ${list.date}
    </span>
    <pre  style="background-color: gray">${list.code}</pre>
</#list>
</body>
</html>