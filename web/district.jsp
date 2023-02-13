<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<option value="">Select District</option>
<c:forEach var="district" items="${DistrictList}">
    <option value="${district.getDistrictCode()}" <c:if test="${district.getDistrictCode()==emp.getDistrictCode()}"> Selected </c:if>>
        ${district.getDistrictName()}
    </option>
</c:forEach>