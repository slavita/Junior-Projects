<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<b>СТРАНИЦА ПРОДУКТА</b>
<br/> 
<br/> Имя : ${product.name}   
<br/> 
<a href="./productAddToBucket.do?id=${product.id}"> Добавить этот продукт в корзину</a>
<hr/>
<a href="./productRemoveToBucket.do?id=${product.id}"> Удалить этот продукт из корзины</a>
<hr/>
<h2>Продукты в корзине</h2>
<ul>
    <c:forEach var="productInBucket" items="${productsInBucket}">
        <li>
            <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name} =
            ${productInBucket.value}
            </a>
         
        </li>
    </c:forEach>
</ul>
</body>
</html>
