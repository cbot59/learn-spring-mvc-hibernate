<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>List Customers</title>
</head>
<body>

  <div id="wrapper">
    <div id="header">
      <h2>CRM - Customer Relationship Manager</h2>
    </div>

    <div id="container">
      <div id="content">

        <input type="button" value="Add Customer"
          onclick="window.location.href='showFormForAddCustomer'; return false;"
          class="add-button" />

        <form:form action="findCustomer" method="POST" name="searchForm" onsubmit="return isEmpty()">
                Search customer: <input type="text"
            name="searchCustomerName" required />

          <input type="submit" value="Search" class="add-button" />
        </form:form>

        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email Name</th>
            <th>Action</th>
          </tr>

          <c:forEach var="tempCustomer" items="${customers}">

            <c:url var="updateLink"
              value="/customer/showFormForUpdateCustomer">
              <c:param name="customerId" value="${tempCustomer.id}"></c:param>
            </c:url>
            <c:url var="deleteLink" value="/customer/deleteCustomer">
              <c:param name="customerId" value="${tempCustomer.id}"></c:param>
            </c:url>

            <tr>
              <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
              <td><a href="${updateLink}">Update</a> | <a
                href="${deleteLink}"
                onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a></td>
            </tr>

          </c:forEach>

        </table>
      </div>
    </div>
  </div>

</body>

<script type="text/javascript">
	function isEmpty() {
		var name = document.forms["searchForm"]["searchCustomerName"].value;
		name = name.trim();
		if (name == null || name == "") {
			alert("Please input a name");
			return false;
		}
		return true;
	}
</script>
</html>