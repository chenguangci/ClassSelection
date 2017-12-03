<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>欢迎</title>
    <link href="${path}resource/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<img src="${path}resource/image/title.png">
<div id="form-main">
    <div id="form-div">
        <h3 style="color: red"><%=request.getAttribute("error")==null?"":request.getAttribute("error")%></h3>
        <form class="form" id="form1" action="login.action" method="post">
            <p class="name">
                <input name="username" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="用户名" id="name" />
            </p>
            <p class="password">
                <input name="password" type="password" class="validate[required,custom[email]] feedback-input" id="password" placeholder="密码" />
            </p>

            <button onclick="sub2()" onmouseover="style.backgroundImage='url(/resource/image/login2.png)';"
                    onmouseout="style.backgroundImage='url(/resource/image/login.png)';"
                    style="background: url(/resource/image/login.png);border: 0;width: 127px;height: 60px">
            </button>

        </form>
    </div>
</div>
</body>
</html>
