<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<b>СПИСОК ПРОДУКТОВ</b>
<br/>
<br/>
    <c:forEach var="productList" items="${productList}">
        <li>
            <a href="product.do?id=${productList.id}"> ${productList.name} </a>
        </li>
    </c:forEach>
</ul>
<hr/>
</body>
</html>
