<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Система учета продуктов</title>
    <style>
        body {
            background-color: #CCFFCC;
            background-image: url(${pageContext.request.contextPath}/download/xls/bg.jpg);
        }
    </style>
</head>
<body align="center">
<%@include file="../header.jsp" %>
<%@include file="nav.jsp" %>
<h1>Весь список продуктов</h1>

<h3 align="right"><a href="${pageContext.request.contextPath}/exportexcel" title="Экспортировать в excel">
    <input type="image" src="${pageContext.request.contextPath}/download/xls/excel.png"
           width="100" height="100" alt="Экспорт в Excel файл" value="Экспорт в Excel файл"></a></h3>

<table class="table" align="center">
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категория</b></th>
        <th colspan="2" align="center"><b> название</b></th>
        <th colspan="2" width="100" align="center"><b> цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> скидка, %</b></th>
        <th colspan="2" width="100" align="center"><b> конечная цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> наличие, кг(шт)</b></th>
        <td></td>
        <td></td>
    </tr>
    <%@include file="sortelement.jsp" %>
    <c:forEach var="product" items="${product}">
        <tr>
            <td colspan="2" align="center"><c:out value="${product.id}"/></td>
            <td colspan="2" align="center"><c:out value="${product.category}"/></td>
            <td colspan="2" align="center"><c:out value="${product.name}"/></td>
            <td colspan="2" align="center"><c:out value="${product.price}"/></td>
            <td colspan="2" align="center"><c:out value="${product.discount}"/></td>
            <td colspan="2" align="center"><c:out value="${product.actualPrice}"/></td>
            <td colspan="2" align="center"><c:out value="${product.totalVolume}"/></td>
            <td><a href="${pageContext.request.contextPath}/product/deleteproduct?id=${product.id}" title="Удалить"
                   onclick="return confirm('Удалить продукт <${product.name}> категории <${product.category}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/del.png"
                    width="18" height="18" alt="Очистить корзину"></a></td>
            <td><a href="${pageContext.request.contextPath}/product/editproduct?id=${product.id}" title="Изменить"
                   onclick="return confirm('Изменить данные <${product.name}> категории <${product.category}>?')"><input
                    type="image" src="${pageContext.request.contextPath}/download/xls/edit.jpg"
                    width="18" height="18" alt="Очистить корзину"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2" width="100" align="center"><b> ID</b></th>
        <th colspan="2" align="center"><b> категория</b></th>
        <th colspan="2" align="center"><b> название</b></th>
        <th colspan="2" width="100" align="center"><b> цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> скидка, %</b></th>
        <th colspan="2" width="100" align="center"><b> конечная цена, BYN</b></th>
        <th colspan="2" width="100" align="center"><b> наличие, кг(шт)</b></th>
        <td></td>
        <td></td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/content">Back</a>
<br>
<br>
<%@include file="../footer.jsp" %>
<br>
<br>
</body>
</html>