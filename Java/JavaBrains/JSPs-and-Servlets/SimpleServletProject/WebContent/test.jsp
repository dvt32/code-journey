<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Testing JSPs</h3>

<%!

public int add(int a, int b) {
	return a + b;
}

%>

<%

int i = 1;
int j = 2;
int k;

k = i + j;

%>

The value of k is: <%=k %>

<%

k = add(1, 3);

%>

The value of k is: <%=k %>

<% 

for (i = 0; i < 5; ++i) {

%>
	<br> The new value of i = <%=i %>
<%
}
%>

</body>
</html>