<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<option value="">Select State</option>
<c:forEach var="prov" items="${ProvinceList}">
    <option value="${prov.getStateCode()}" <c:if test="${prov.getStateCode()==emp.getStateCode()}"> Selected </c:if>>
        ${prov.getStateName()}
    </option>
</c:forEach>